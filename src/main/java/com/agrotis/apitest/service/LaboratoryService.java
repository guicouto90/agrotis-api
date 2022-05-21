package com.agrotis.apitest.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import com.agrotis.apitest.model.Laboratory;
import com.agrotis.apitest.repository.LaboratoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryService {
  
  @Autowired
  private LaboratoryRepository laboratoryRepository;

  public void verifyName(String name) {
    if(name.length() <= 3 || name == null) {
      throw new StringIndexOutOfBoundsException("Name field invalid. It must has at least 3 length");
    }
    Laboratory lab = this.laboratoryRepository.findItemByName(name);
    if(lab != null) {
      throw new EntityExistsException("Laboratory name already registered");
    }
  }

  public Laboratory addLaboratory(Laboratory lab) {
    this.verifyName(lab.getName());
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
    this.verifyName(lab.getName());
    editedLab.setName(lab.getName());
    return this.laboratoryRepository.save(editedLab);
  }
}
