package com.example.crudtesting.repo;


import com.example.crudtesting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MRepository extends JpaRepository<Student, Integer> {
}
