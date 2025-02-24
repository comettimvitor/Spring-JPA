package com.talkevents.mongodb.controllers;

import com.talkevents.mongodb.documents.Address;
import com.talkevents.mongodb.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable String id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        addressService.update(address);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddressById(@PathVariable String id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
