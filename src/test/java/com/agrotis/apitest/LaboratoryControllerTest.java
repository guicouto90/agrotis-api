package com.agrotis.apitest;

import com.agrotis.apitest.model.Laboratory;
import com.agrotis.apitest.repository.LaboratoryRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LaboratoryControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private LaboratoryRepository laboratoryRepository;

  @Test
  void testOk() throws Exception {
    mockMvc
      .perform(MockMvcRequestBuilders.get("/laboratory"))
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testAnSpecificLab() throws Exception {
    var lab = new Laboratory("6287f54c7d7e26187f5a6be1", "Laboratorio Teste");
    laboratoryRepository.save(lab);

    mockMvc
      .perform(MockMvcRequestBuilders.get("/laboratory/6287f54c7d7e26187f5a6be1"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(lab.getName()))
      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(lab.getId()));
  }

  @Test
  void testLabNotFound() throws Exception {

    mockMvc
      .perform(MockMvcRequestBuilders.get("/laboratory/6287f54c7d7e26187f5a6be"))
      .andExpect(MockMvcResultMatchers.status().isNotFound())
      .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Laboratory not found"));
  }

  @Test
  void testDeleteLabById() throws Exception {
    var lab = new Laboratory("6287f54c7d7e26187f5a6be2", "Laboratorio Teste2");
    laboratoryRepository.save(lab);

    mockMvc
      .perform(MockMvcRequestBuilders.delete("/laboratory/6287f54c7d7e26187f5a6be2"))
      .andExpect(MockMvcResultMatchers.status().isNoContent());
  }
}
