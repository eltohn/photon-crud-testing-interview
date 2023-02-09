package com.example.crudtesting.service;

import com.example.crudtesting.exception.EmptyInputException;
import com.example.crudtesting.model.Student;

import java.util.List;

public interface SService {
    Student addStudent(Student student) throws EmptyInputException;

    List<Student> getAllStudents();

    Student getById(Integer id);

    void deleteStudent(Integer id);

    Student updateStudentName(Student student, Integer id);

    void updateStudent(Student student, Integer id);
}
