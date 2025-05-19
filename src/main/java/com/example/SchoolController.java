package com.example;

import java.util.List;

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

    @PostMapping(value="/schools",consumes = MediaType.APPLICATION_JSON_VALUE)

    public School create(@RequestBody School school) {

        return schoolRepository.save(school);

    }

    @GetMapping("/schools")
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

}
