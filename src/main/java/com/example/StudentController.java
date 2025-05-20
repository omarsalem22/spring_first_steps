package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    // @GetMapping("/students")

    // public List<Student> findAllStudents() {
    // return repository.findAll();
    // }

    // @GetMapping("/students/{student-id}")
    // public Student findStudentById(@PathVariable("student-id") Long id) {
    // return repository.findById(id).orElse(new Student());
    // }

    // @GetMapping("/students/search/{student-name}")
    // public List<Student> findByName(@PathVariable("student-name") String name) {

    // return repository.findByNameContainingIgnoreCase(name);

    // }

    // @DeleteMapping("/students/{student-id}")
    // @ResponseStatus(HttpStatus.OK)
    // public void delete(@PathVariable("student-id") long id) {
    // repository.deleteById(id);
    // }

}
