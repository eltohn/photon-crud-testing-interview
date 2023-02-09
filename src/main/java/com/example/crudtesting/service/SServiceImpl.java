package com.example.crudtesting.service;

import com.example.crudtesting.exception.EmptyInputException;
import com.example.crudtesting.model.Student;
import com.example.crudtesting.repo.MRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SServiceImpl implements SService{

    @Autowired
    private MRepository repository;
    @Override
    public Student addStudent(Student student)  {
        String name = student.getFirstName();
        String lastname = student.getLastName();
        if(name.isEmpty() || lastname.isEmpty() || name.length() == 0 || lastname.length() == 0 ){
           throw  new EmptyInputException("Some needed spaces are empty","400");
        }
        Student newStudent = repository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = repository.findAll();
        return allStudents;
    }

    @Override
    public Student getById(Integer id) {
        Student retrievedStudent = repository.findById(id).get();
        return retrievedStudent;
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Student updateStudentName(Student student, Integer id) {
        Student oldStudent = repository.findById(id).get();
        oldStudent.setFirstName(student.getFirstName());
        repository.save(oldStudent);
        return oldStudent;
    }

    @Override
    public void updateStudent(Student student, Integer id) {
        Student oldStudent = repository.findById(id).get();
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        repository.save(oldStudent);
    }
}
