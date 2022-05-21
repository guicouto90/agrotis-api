package com.agrotis.apitest.controller;

import java.util.List;

import com.agrotis.apitest.model.Register;
import com.agrotis.apitest.service.RegisterService;

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
@RequestMapping("/register")
public class RegisterController {
  
  @Autowired
  private RegisterService registerService;

  @GetMapping
  public ResponseEntity<?> getAllRegisters() {
    List<Register> registers = this.registerService.findAllRegisters();
    return new ResponseEntity<>(registers, HttpStatus.OK);
  }

  @GetMapping("/{registerId}")
  public ResponseEntity<?> getRegisterById(@PathVariable String registerId) {
    Register register = registerService.findRegisterById(registerId);
    return new ResponseEntity<>(register, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> newRegister(@RequestBody Register register) {
    Register newRegister = this.registerService.addRegister(register);
    return new ResponseEntity<>(newRegister, HttpStatus.CREATED);
  }

  @DeleteMapping("/{registerId}")
  public ResponseEntity<?> eraseRegisterById(@PathVariable String registerId) {
    this.registerService.deleteRegisterById(registerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{registerId}")
  public ResponseEntity<?> editRegisterById(@PathVariable String registerId, @RequestBody Register register) {
    Register editedRegister = this.registerService.updateRegisterById(registerId, register);
    return new ResponseEntity<>(editedRegister, HttpStatus.ACCEPTED);
  }
}
