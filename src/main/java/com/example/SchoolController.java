package com.example;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.School;

@RestController
public class SchoolController {

    final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping(value = "/schools", consumes = MediaType.APPLICATION_JSON_VALUE)

    public SchoolDto create(@RequestBody SchoolDto dto) {
        var school = toSchool(dto);

        schoolRepository.save(school);
        return dto;

    }

    public School toSchool(SchoolDto dto) {

        return new School(dto.name());
    }

    private SchoolDto toSchoolDto(School school) {

        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {

        return schoolRepository.findAll().stream().map(this::toSchoolDto).collect(Collectors.toList());
    }

}
