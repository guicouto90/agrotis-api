package com.agrotis.apitest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Laboratory {
  
  @Id
  private String id;
  private String name;

  public Laboratory(String id,String name) {
    super();
    this.id = id;
    this.setName(name);
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

}
