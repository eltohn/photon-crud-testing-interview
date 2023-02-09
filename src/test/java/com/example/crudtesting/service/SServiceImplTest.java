package com.example.crudtesting.service;

import com.example.crudtesting.model.Student;
import com.example.crudtesting.repo.MRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SServiceImplTest {

    @Mock
    private MRepository repository;
    @InjectMocks
    private SServiceImpl service;

    @Test
    void addStudent() {
        Student testStudent = new Student(1,"firstname","lastname");
        when(repository.save(testStudent)).thenReturn(testStudent);
        assertEquals(service.addStudent(testStudent), testStudent);
    }

    @Test
    void getAllStudents() {
        Student testStudent = new Student(1,"firstname","lastname");
        Student testStudent1 = new Student(2,"firstname","lastname");
        Student testStudent2 = new Student(3,"firstname","lastname");

        List<Student> testListStudent = new ArrayList<Student>();
        testListStudent.add(testStudent);
        testListStudent.add(testStudent1);
        testListStudent.add(testStudent2);

        when(repository.findAll()).thenReturn(testListStudent);
        assertEquals(testListStudent.size(), service.getAllStudents().size());
    }

    @Test
    void getById() {
        when(repository.findById(1)).thenReturn(getByIdStub(1));
        Student testStudent = service.getById(1);
        assertEquals(testStudent.getFirstName(), "testName");
    }
    private Optional<Student> getByIdStub(Integer id){
        Student stubStudent = new Student(id,"testName", "testLastName");
        return  Optional.of(stubStudent);
    }


    @Test
    void deleteStudent() {
//        Student testStudent = new Student(1,"firstname","lastname");
         service.deleteStudent(1);
         verify(repository, times(1)).deleteById(1);
    }

    @Test
    void updateStudentName() {
        Student testStudent = new Student(1,"firstname","lastname");
        when(repository.findById(1)).thenReturn(Optional.of(testStudent));
        testStudent.setFirstName("Elbek");
        when(repository.save(testStudent)).thenReturn(testStudent);

        Student expectedStudent = new Student(1,"Elbek","lastname");
        assertEquals(service.updateStudentName(expectedStudent, 1), testStudent );
    }

    @Test
    void updateStudent() {
    }
}