package com.talkevents.mongodb.services;

import com.talkevents.mongodb.documents.Address;
import com.talkevents.mongodb.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(String id) {
        return addressRepository.findById(id).orElseThrow(null);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void update(Address address) {
        var addressUpdate = getById(address.getId());

        if(addressUpdate == null) return;

        addressUpdate.setStreet(address.getStreet());
        addressUpdate.setCity(address.getCity());
        addressUpdate.setCountry(address.getCountry());
        addressRepository.save(addressUpdate);
    }

    public void delete(String id) {
        addressRepository.deleteById(id);
    }
}
