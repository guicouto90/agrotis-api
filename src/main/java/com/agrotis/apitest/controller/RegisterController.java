package com.agrotis.apitest.controller;

import java.util.List;

import com.agrotis.apitest.model.Register;
import com.agrotis.apitest.service.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
  
  @Autowired
  private RegisterService registerService;

  @GetMapping
  public List<Register> getAllRegisters() {
    return this.registerService.findAllRegisters();
  }

  @GetMapping("/{registerId}")
  public Register getRegisterById(@PathVariable String registerId) {
    return registerService.findRegisterById(registerId);
  }

  @PostMapping
  public Register newRegister(@RequestBody Register register) {
    return this.registerService.addRegister(register);
  }

  @DeleteMapping("/{registerId}")
  public void eraseRegisterById(@PathVariable String registerId) {
    this.registerService.deleteRegisterById(registerId);
  }
}
