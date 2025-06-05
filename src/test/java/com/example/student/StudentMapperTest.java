package com.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.entities.School;
import com.example.entities.Student;

public class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    void testMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("omar", "omar@yahoo.com", 23, 1);
        Student student = mapper.toStudent(dto);
        assertEquals(dto.name(), student.getName());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(dto.age(), student.getAge());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    void testMapStudentToStudentDto() {
        Student student = new Student("aya", "aya@yahoo.com", 22);
        School school = new School("ghazaa");
        student.setSchool(school);
        StudentResponseDto dto = mapper.toStudentResponseDto(student);
        assertEquals(dto.name(), student.getName());
        assertEquals(dto.email(), student.getEmail());

    }
}
