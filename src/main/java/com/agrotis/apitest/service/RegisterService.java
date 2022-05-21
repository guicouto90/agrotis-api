package com.agrotis.apitest.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

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

  public void verifyName(String name) {
    if(name.length() <= 3 || name == null || Pattern.matches("[0-9]+", name) == true) {
      throw new StringIndexOutOfBoundsException("Name field invalid. It must has at least 3 length and cannot be a number");
    }
  }

  public void verifyDate(LocalDate date) {
    DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateString = datePattern.format(date);
    if(Pattern.matches("\\d{4}-\\d{2}-\\d{2}", dateString) == false) {
      throw new DateTimeException("Date Format Invalid, it must be YYYY-MM-DD");
    }
  }
  
  public Register addRegister(Register register) {
    this.verifyDate(register.getInitialDate());
    this.verifyDate(register.getFinalDate());
    Property property = this.propertyRepository
      .findById(register.getPropertyInfo().getId())
      .orElseThrow(() -> new IllegalArgumentException("Property not found"));

    Laboratory lab = this.laboratoryRepository
      .findById(register.getLaboratory().getId())
      .orElseThrow(() -> new IllegalArgumentException("Laboratory not found"));

    this.verifyName(register.getName());

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

  public Register updateRegisterById(String id, Register register) {
    Register editedRegister = this.findRegisterById(id);

    Property property = this.propertyRepository
      .findById(register.getPropertyInfo().getId())
      .orElseThrow(() -> new IllegalArgumentException("Property not found"));

    Laboratory lab = this.laboratoryRepository
      .findById(register.getLaboratory().getId())
      .orElseThrow(() -> new IllegalArgumentException("Laboratory not found"));
    
    editedRegister.setPropertyInfo(property);
    editedRegister.setLaboratory(lab);

    this.verifyName(register.getName());
    editedRegister.setName(register.getName());
    editedRegister.setNote(register.getNote());
    editedRegister.setInitialDate(register.getInitialDate());
    editedRegister.setFinalDate(register.getFinalDate());

    return this.registerRepository.save(editedRegister);
  }

}
