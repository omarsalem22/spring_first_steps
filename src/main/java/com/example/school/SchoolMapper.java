package com.example.school;

import org.springframework.stereotype.Service;

import com.example.entities.School;

@Service

public class SchoolMapper {

    public School toSchool(SchoolDto dto) {

        return new School(dto.name());
    }

    public SchoolDto toSchoolDto(School school) {

        return new SchoolDto(school.getName(),school.getId());
    }

}
