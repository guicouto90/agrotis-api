package com.agrotis.apitest.repository;

import com.agrotis.apitest.model.Property;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepository extends MongoRepository<Property, String> {
  
  @Query("{cnpj:'?0'}")
  Property findItemByCnpj(String cnpj);

  @Query("{name:'?0'}")
  Property findItemByName(String name);
}
