package com.adviceapp.adviceapp.controller;

import com.adviceapp.adviceapp.dto.UserPreferencesDto;
import com.adviceapp.adviceapp.service.impl.UserPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/matchPreferences")
public class UserPreferencesController {
    private final UserPreferencesService userPreferencesService;

    @Autowired
    public UserPreferencesController(UserPreferencesService userPreferencesService) {
        this.userPreferencesService = userPreferencesService;
    }
    @PostMapping
    public ResponseEntity<String> matchUserPreferences(@RequestBody UserPreferencesDto userPreferencesDto) {
        userPreferencesService.matchUserPreferences(userPreferencesDto);
        return new ResponseEntity<>("User preferences matched successfully", HttpStatus.OK);
    }
}
