package com.agrotis.apitest.controller;

import java.util.List;

import com.agrotis.apitest.model.Property;
import com.agrotis.apitest.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {
  
  @Autowired
  private PropertyService propertyService;

  @GetMapping
  public List<Property> getAllProperties() {
    return this.propertyService.findAllProperties();
  }

  @GetMapping("/{propertyId}")
  public Property getPropertyById(@PathVariable String propertyId) {
    return propertyService.findPropertyById(propertyId);
  }

  @PostMapping
  public Property newProperty(@RequestBody Property property) {
    return this.propertyService.addProperty(property);
  }

  @PutMapping("/{propertyId}")
  public Property editPropertyById(@PathVariable String propertyId, @RequestBody Property property) {
    return this.propertyService.updatePropertyById(propertyId, property);
  }

  @DeleteMapping("/{propertyId}")
  public void erasePropertyById(@PathVariable String propertyId) {
    this.propertyService.deletePropertyById(propertyId);
  }
}
