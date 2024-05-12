package com.adviceapp.adviceapp.service;

import com.adviceapp.adviceapp.dto.UserPreferencesDto;
import com.adviceapp.adviceapp.entity.Content;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.repository.ContentRepository;
import com.adviceapp.adviceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void matchUserPreferences(UserPreferencesDto userPreferencesDto) {
        List<Content> userSelectedContents = contentRepository.findByCategoryId(userPreferencesDto.getCategoryId());
        User user = userRepository.findById(userPreferencesDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        userSelectedContents.stream().forEach(content ->  {
            var availabilityDuration = userPreferencesDto.getAvailabilityDuration();
            if(content.getDuration() < availabilityDuration) {
                userSelectedContents.add(content);
                availabilityDuration =  availabilityDuration - content.getDuration();
            }
        user.getContents().addAll(userSelectedContents);
        userRepository.save(user);
    });
  }
}
