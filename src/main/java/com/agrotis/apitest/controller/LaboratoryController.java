package com.agrotis.apitest.controller;

import java.util.List;

import com.agrotis.apitest.model.Laboratory;
import com.agrotis.apitest.service.LaboratoryService;

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
@RequestMapping("/laboratory")
public class LaboratoryController {
  
  @Autowired
  private LaboratoryService laboratoryService;

  @PostMapping
  public ResponseEntity<?> newLab(@RequestBody Laboratory laboratory) {
    Laboratory newLaboratory = this.laboratoryService.addLaboratory(laboratory);
    return new ResponseEntity<>(newLaboratory, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<?> getAllLabs() {
    List<Laboratory> laboratories = this.laboratoryService.findLaboratories();
    return new ResponseEntity<>(laboratories, HttpStatus.OK);
  } 

  @GetMapping("/{labId}")
  public ResponseEntity<?> getAllLabs(@PathVariable String labId) {
    Laboratory lab = this.laboratoryService.findLaboratoryById(labId);
    return new ResponseEntity<>(lab, HttpStatus.OK);
  }

  @PutMapping("{labId}")
  public ResponseEntity<?> editPropertyById(@PathVariable String labId, @RequestBody Laboratory lab) {
    Laboratory labEdited = this.laboratoryService.updateLaboratoryById(labId, lab);
    return new ResponseEntity<>(labEdited, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{labId}")
  public ResponseEntity<?> erasePropertyById(@PathVariable String labId) {
    this.laboratoryService.deleteLaboratoryById(labId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
