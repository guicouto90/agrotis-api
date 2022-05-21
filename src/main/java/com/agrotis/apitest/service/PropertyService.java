package com.agrotis.apitest.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityExistsException;

import com.agrotis.apitest.model.Property;
import com.agrotis.apitest.repository.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
  
  @Autowired
  private PropertyRepository propertyRepository;

  public void verifyCnpj(String cnpj) {
    if(Pattern.matches("[0-9]+", cnpj) == false || cnpj.length() != 14) {
      throw new StringIndexOutOfBoundsException("CNPJ not valid. It must be just numbers and it must has length of 14");
    }
    Property property = this.propertyRepository.findItemByCnpj(cnpj);
    if(property != null) {
      throw new EntityExistsException("CNPJ already registered");
    }
  }

  public void verifyName(String name) {
    if(name.length() <= 3 || name == null) {
      throw new StringIndexOutOfBoundsException("Name field invalid. It must has at least 3 length");
    }
    Property property = this.propertyRepository.findItemByName(name);
    if(property != null) {
      throw new EntityExistsException("Property name already registered");
    }
  }

  public Property addProperty(Property property) {
    this.verifyName(property.getName());
    this.verifyCnpj(property.getCnpj());
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
    Property editedProperty = this.findPropertyById(id);
    this.verifyCnpj(property.getCnpj());
    this.verifyName(property.getName());
    editedProperty.setCnpj(property.getCnpj());
    editedProperty.setName(property.getName());
    return this.propertyRepository.save(editedProperty);
  }
}
