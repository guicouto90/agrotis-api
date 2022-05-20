package com.agrotis.apitest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Property {
  
  @Id
  private String id;

  private String name;
  private String cnpj;

  public Property(String id, String name, String cnpj) {
    super();
    this.id = id;
    this.setName(name);
    this.setCnpj(cnpj);
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

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCnpj() {
    return cnpj;
  }
}
