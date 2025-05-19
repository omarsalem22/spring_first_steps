package com.example;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Student;

@RestController

public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")

    public Student post(@RequestBody StudentDto dto) {
        var student = toStudent(dto);
        return repository.save(student);

    }


    private Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setName(dto.name());
        // student.setAge(dto.age());
        student.setEmail(dto.email());
        // var school = new School();
        // school.setId(dto.school_id());
        // student.setSchool(school);
        return student;
    }

    @GetMapping("/students")

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Long id) {
        return repository.findById(id).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findByName(@PathVariable("student-name") String name) {

        return repository.findByNameContainingIgnoreCase(name);

    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") long id) {
        repository.deleteById(id);
    }

}
