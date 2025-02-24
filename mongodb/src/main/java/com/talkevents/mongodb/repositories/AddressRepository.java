package com.talkevents.mongodb.repositories;

import com.talkevents.mongodb.documents.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
}
