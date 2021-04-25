package com.gitprofiles.controller;

import com.gitprofiles.dto.ProfileDto;
import com.gitprofiles.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ProfilesController {

    private final ProfileService profileService;

    @Autowired
    public ProfilesController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{login}")
    public ResponseEntity<ProfileDto> getUser(@PathVariable final String login) {
        return ResponseEntity.ok(profileService.getProfileByLogin(login));
    }
}
