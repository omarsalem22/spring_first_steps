package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.school.SchoolDto;
import com.example.school.SchoolRepository;

@Service
public class SchoolService {

    final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public void create(SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);

    }

    public List<SchoolDto> getAll() {
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDto).collect(Collectors.toList());
    }

}
