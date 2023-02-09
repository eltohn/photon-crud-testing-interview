package com.example.crudtesting.controller;

import com.example.crudtesting.model.Student;
import com.example.crudtesting.service.SService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private SService service;



    @PostMapping("/add")
    private ResponseEntity<Student> addStudent(@RequestBody @Valid Student student){
        Student newStudent = service.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping ("/students/all")
    private ResponseEntity<List<Student>> getAll(){
        List<Student> allStudents = service.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping ({"/students", "/students/{id}"})
    private ResponseEntity<Student> getAll(@PathVariable(name = "id", required = false) Integer id){
        Student student = service.getById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    private ResponseEntity<Void> addStudent(@PathVariable Integer id){
        service.deleteStudent(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/students/{id}")
    private ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        service.updateStudent(student, id);
        return ResponseEntity.ok("Saved");
    }

    @PatchMapping("/students/{id}")
    private ResponseEntity<String> updateName(@RequestBody Student student, @PathVariable Integer id) {
        service.updateStudentName(student, id);
        return ResponseEntity.ok("Saved");
    }

}
