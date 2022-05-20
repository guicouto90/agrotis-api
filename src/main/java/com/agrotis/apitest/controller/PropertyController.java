package com.agrotis.apitest.controller;

import java.util.List;

import com.agrotis.apitest.model.Property;
import com.agrotis.apitest.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> getAllProperties() {
    List<Property> property = this.propertyService.findAllProperties();
    return new ResponseEntity<>(property, HttpStatus.OK);
  }

  @GetMapping("/{propertyId}")
  public ResponseEntity<?> getPropertyById(@PathVariable String propertyId) {
    Property property = propertyService.findPropertyById(propertyId);
    return new ResponseEntity<>(property, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> newProperty(@RequestBody Property property) {
    Property newProperty = this.propertyService.addProperty(property);
    return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
  }

  @PutMapping("/{propertyId}")
  public ResponseEntity<?> editPropertyById(@PathVariable String propertyId, @RequestBody Property property) {
    Property editedProperty = this.propertyService.updatePropertyById(propertyId, property);
    return new ResponseEntity<>(editedProperty, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{propertyId}")
  public ResponseEntity<?> erasePropertyById(@PathVariable String propertyId) {
    this.propertyService.deletePropertyById(propertyId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
