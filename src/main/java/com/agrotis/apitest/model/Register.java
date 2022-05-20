package com.agrotis.apitest.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Register {
  
  @Id
  private String id;

  private String name;
  private LocalDateTime initialDate;
  private LocalDateTime finalDate;

  @DBRef
  private Property propertyInfo;

  @DBRef
  private Laboratory laboratory;
  private String note;

  public Register(String id, String name, Property propertyInfo, Laboratory laboratory, String note) {
    super();
    this.id = id;
    this.setName(name);
    this.initialDate = LocalDateTime.now();
    this.finalDate = LocalDateTime.now();
    this.setNote(note);
    this.setLaboratory(laboratory);
    this.setPropertyInfo(propertyInfo);
  }

  public String getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  public void setNote(String note) {
    this.note = note;
  }

  public String getNote() {
    return note;
  }

  public void setInitialDate(LocalDateTime date) {
    this.initialDate = date;
  }

  public LocalDateTime getInitialDate() {
    return initialDate;
  }

  public void setFinalDate(LocalDateTime date) {
    this.finalDate = date;
  }

  public LocalDateTime getFinalDate() {
    return finalDate;
  }

  public void setPropertyInfo(Property property) {
    this.propertyInfo = property;
  }

  public Property getPropertyInfo() {
    return propertyInfo;
  }

  public void setLaboratory(Laboratory lab) {
    this.laboratory = lab;
  }

  public Laboratory getLaboratory() {
    return laboratory;
  }

}
