package com.example.student;

import org.springframework.stereotype.Service;

import com.example.entities.School;
import com.example.entities.Student;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setName(dto.name());
        student.setEmail(dto.email());
        student.setAge(dto.age());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getName(), student.getEmail(), student.getSchool().getId());
    }

}
