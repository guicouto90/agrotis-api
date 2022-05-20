package com.agrotis.apitest.repository;

import com.agrotis.apitest.model.Property;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepository extends MongoRepository<Property, String> {
  
}
