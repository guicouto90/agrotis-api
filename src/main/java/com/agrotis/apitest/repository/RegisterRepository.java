package com.agrotis.apitest.repository;

import com.agrotis.apitest.model.Register;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepository extends MongoRepository<Register, String> {
  
}
