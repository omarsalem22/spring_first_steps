package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.StudentProfile;

@RestController
public class ProfileController {
    final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @PostMapping("/profiles")
    public StudentProfile create(@RequestBody StudentProfile studentProfile) {
        return profileRepository.save(studentProfile);
    }

    @GetMapping("/profiles")
    public List<StudentProfile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping("/profiles/{profile-id}")
    public StudentProfile getById(@PathVariable("profile-id") int id) {
        return profileRepository.findById(id).orElse(new StudentProfile());
    }
}
