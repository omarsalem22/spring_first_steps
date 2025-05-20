package com.example;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Student;
import com.example.service.StudentService;

@RestController

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)

    public StudentResponseDto saveStudent(@RequestBody StudentDto dto) {
        return this.studentService.saveStudent(dto);

    }

    @GetMapping("/students")

    public List<StudentResponseDto> getAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findByName(@PathVariable("student-name") String name) {

        return studentService.findByName(name);

    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") long id) {

        this.studentService.delete(id);
    }

}
