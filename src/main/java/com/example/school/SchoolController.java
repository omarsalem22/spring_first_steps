package com.example.school;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping(value = "/schools", consumes = MediaType.APPLICATION_JSON_VALUE)

    public SchoolDto create(@RequestBody SchoolDto dto) {

        schoolService.create(dto);
        
        return dto;

    }

    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {

        return schoolService.getAll();
    }

}
