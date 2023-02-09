package com.example.crudtesting.controller;

import com.example.crudtesting.model.Student;
import com.example.crudtesting.service.SService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(MainController.class)
@ExtendWith(Power)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SService service;

    @Test
    public void addStudentTest() throws Exception {
        Student student = new Student(1,"firstname","lastname");

        ObjectMapper ow = new ObjectMapper();
        String json = ow.writeValueAsString(student);

        String URI = "/add";
        MvcResult mvcResult = mockMvc.perform(post(URI).content(json)
                .content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String resultContent = mvcResult.getResponse().getContentAsString();
        Student response = ow.readValue(resultContent, Student.class);
        assertEquals(response, json);
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}