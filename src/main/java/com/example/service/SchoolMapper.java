package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entities.School;
import com.example.school.SchoolDto;

@Service

public class SchoolMapper {

    public School toSchool(SchoolDto dto) {

        return new School(dto.name());
    }

    public SchoolDto toSchoolDto(School school) {

        return new SchoolDto(school.getName());
    }

}
