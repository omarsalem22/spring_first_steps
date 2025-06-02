package com.example.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.StudentProfile;

public interface ProfileRepository extends JpaRepository<StudentProfile, Integer> {

}
