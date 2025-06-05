package com.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message="put name") String name,
        @NotEmpty String email,
        int age,
        int schoolId) {

}
