package com.talkevents.mongodb.services;

import com.talkevents.mongodb.documents.Address;
import com.talkevents.mongodb.documents.User;
import com.talkevents.mongodb.repositories.AddressRepository;
import com.talkevents.mongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        if(user.getAddress() != null && user.getAddress().getId() != null) {
            Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);
            user.setAddress(Objects.requireNonNullElseGet(address, () -> addressRepository.save(user.getAddress())));
        } else if(user.getAddress() != null) {
            user.setAddress(addressRepository.save(user.getAddress()));
        }

        return userRepository.save(user);

    }

    public void update(User user) {
        var userUpdate = getById(user.getId());

        if(userUpdate == null) {
            userUpdate.setName(user.getName());
            userUpdate.setAge(user.getAge());
            userRepository.save(userUpdate);

            if(user.getAddress() != null) {
                Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);
                userUpdate.setAddress(Objects.requireNonNullElseGet(address, () -> addressRepository.save(user.getAddress())));
            }
        }
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
