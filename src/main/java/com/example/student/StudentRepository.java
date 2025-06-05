 package com.example.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String p);
}
