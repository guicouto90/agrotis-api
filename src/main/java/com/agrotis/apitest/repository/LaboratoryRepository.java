package com.agrotis.apitest.repository;

import com.agrotis.apitest.model.Laboratory;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaboratoryRepository extends MongoRepository<Laboratory, String> {
  
}
