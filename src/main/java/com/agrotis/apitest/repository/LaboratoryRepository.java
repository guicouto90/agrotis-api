package com.agrotis.apitest.repository;

import com.agrotis.apitest.model.Laboratory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.Query;

public interface LaboratoryRepository extends MongoRepository<Laboratory, String> {
  
  @Query("{name:'?0'}")
  Laboratory findItemByName(String name);
}
