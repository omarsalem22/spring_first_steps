package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.StudentDto;
import com.example.StudentRepository;
import com.example.StudentResponseDto;
import com.example.entities.Student;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);

    }

    public void delete(long id) {
        this.repository.deleteById(id);
    }

    public List<StudentResponseDto> findAllStudents() {
        return repository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public List<Student> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Student findById(Long id) {
        return repository.findById(id).orElse(new Student());
    }

}
