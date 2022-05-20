package com.agrotis.apitest.controller;

import java.util.List;

import com.agrotis.apitest.model.Laboratory;
import com.agrotis.apitest.service.LaboratoryService;

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
@RequestMapping("/laboratory")
public class LaboratoryController {
  
  @Autowired
  private LaboratoryService laboratoryService;

  @PostMapping
  public Laboratory newLab(@RequestBody Laboratory laboratory) {
    return this.laboratoryService.addLaboratory(laboratory);
  }

  @GetMapping
  public List<Laboratory> getAllLabs() {
    return this.laboratoryService.findLaboratories();
  } 

  @GetMapping("/{labId}")
  public Laboratory getAllLabs(@PathVariable String labId) {
    return this.laboratoryService.findLaboratoryById(labId);
  }

  @PutMapping("{labId}")
  public Laboratory editPropertyById(@PathVariable String labId, @RequestBody Laboratory lab) {
    return this.laboratoryService.updateLaboratoryById(labId, lab);
  }

  @DeleteMapping("/{labId}")
  public void erasePropertyById(@PathVariable String labId) {
    this.laboratoryService.deleteLaboratoryById(labId);
  }
}
