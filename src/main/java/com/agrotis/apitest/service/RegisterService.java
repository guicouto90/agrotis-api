package com.agrotis.apitest.service;

import java.util.List;

import com.agrotis.apitest.model.Register;
import com.agrotis.apitest.repository.LaboratoryRepository;
import com.agrotis.apitest.repository.PropertyRepository;
import com.agrotis.apitest.repository.RegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

  @Autowired
  private RegisterRepository registerRepository;

  private PropertyRepository propertyRepository;

  private LaboratoryRepository laboratoryRepository;
  
  public Register addRegister(Register register) {
    try {
      this.propertyRepository
        .findById(register.getPropertyInfo().getId())
        .orElseThrow(() -> new IllegalArgumentException("Property not found"));

      this.laboratoryRepository
        .findById(register.getLaboratory().getId())
        .orElseThrow(() -> new IllegalArgumentException("Laboratory not found"));

      return this.registerRepository.save(register);
    } catch (Exception e) {
      throw e;
    }
  }

  public List<Register> findAllRegisters() {
    return this.registerRepository.findAll();
  }

  public Register findRegisterById(String id) {
    return this.registerRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Register not found"));
  }

  public void deleteRegisterById(String id) {
    this.registerRepository.deleteById(id);
  }
}
