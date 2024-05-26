package com.adviceapp.adviceapp.service.impl;

import com.adviceapp.adviceapp.dto.UserPreferencesDto;
import com.adviceapp.adviceapp.entity.Content;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.repository.ContentRepository;
import com.adviceapp.adviceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPreferencesService {

    private final ContentRepository contentRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserPreferencesService(ContentRepository contentRepository, UserRepository userRepository) {
        this.contentRepository = contentRepository;
        this.userRepository = userRepository;
    }

    public List<Long> matchUserPreferences(UserPreferencesDto userPreferencesDto) {
        List<Content> availableContents = contentRepository.findByCategoryId(userPreferencesDto.getCategoryId());
        User user = userRepository.findById(userPreferencesDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<Content> selectedContents = new ArrayList<>();
        double availabilityDuration = userPreferencesDto.getAvailabilityDuration();

        for (Content content : availableContents) {
            // Check if the duration is not null and is less than or equal to the available duration
            if (content.getDuration() != null && content.getDuration() <= availabilityDuration) {
                selectedContents.add(content);
                availabilityDuration -= content.getDuration();
            }
            if (availabilityDuration <= 0) {
                break;
            }
        }

        user.getContents().addAll(selectedContents);
        userRepository.save(user);
        return selectedContents.stream().map(it -> it.getId()).toList();
    }
}
