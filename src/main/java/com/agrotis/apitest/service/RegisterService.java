package com.agrotis.apitest.service;

import java.util.List;
// import java.util.Objects;

// import com.agrotis.apitest.exceptions.ResourceNotFoundException;
import com.agrotis.apitest.model.Laboratory;
import com.agrotis.apitest.model.Property;
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

  @Autowired
  private PropertyRepository propertyRepository;

  @Autowired
  private LaboratoryRepository laboratoryRepository;
  
  public Register addRegister(Register register) {
    Property property = this.propertyRepository
      .findById(register.getPropertyInfo().getId())
      .orElseThrow(() -> new IllegalArgumentException("Property not found"));

    Laboratory lab = this.laboratoryRepository
      .findById(register.getLaboratory().getId())
      .orElseThrow(() -> new IllegalArgumentException("Laboratory not found"));

    register.setPropertyInfo(property);
    register.setLaboratory(lab);

    return this.registerRepository.save(register);
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
