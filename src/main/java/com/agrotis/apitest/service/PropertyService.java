package com.agrotis.apitest.service;

import java.util.List;

import com.agrotis.apitest.model.Property;
import com.agrotis.apitest.repository.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
  
  @Autowired
  private PropertyRepository propertyRepository;

  public Property addProperty(Property property) {
    return this.propertyRepository.save(property);
  }

  public List<Property> findAllProperties() {
    return this.propertyRepository.findAll();
  }

  public Property findPropertyById(String id) {
    return this.propertyRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Property not found"));
  }

  public void deletePropertyById(String id) {
    this.propertyRepository.deleteById(id);
  }

  public Property updatePropertyById(String id, Property property) {
    Property editedProperty = findPropertyById(id);
    editedProperty.setCnpj(property.getCnpj());
    editedProperty.setName(property.getName());
    return this.propertyRepository.save(editedProperty);
  }
}
