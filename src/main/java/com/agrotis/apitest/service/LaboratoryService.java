package com.agrotis.apitest.service;

import java.util.List;

import com.agrotis.apitest.model.Laboratory;
import com.agrotis.apitest.repository.LaboratoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryService {
  
  @Autowired
  private LaboratoryRepository laboratoryRepository;

  public Laboratory addLaboratory(Laboratory lab) {
    System.out.println(lab);
    return this.laboratoryRepository.save(lab);
  }

  public List<Laboratory> findLaboratories() {
    return this.laboratoryRepository.findAll();
  }

  public Laboratory findLaboratoryById(String id) {
    return this.laboratoryRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Laboratory not found"));
  }

  public void deleteLaboratoryById(String id) {
    this.laboratoryRepository.deleteById(id);
  }

  public Laboratory updateLaboratoryById(String id, Laboratory lab) {
    Laboratory editedLab = findLaboratoryById(id);
    editedLab.setName(lab.getName());
    return this.laboratoryRepository.save(editedLab);
  }
}
