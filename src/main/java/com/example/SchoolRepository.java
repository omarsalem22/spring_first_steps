package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
