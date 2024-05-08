package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.UserInterestDto;
import com.adviceapp.adviceapp.entity.Category;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.entity.UserInterest;

import java.util.ArrayList;
import java.util.List;

public class UserInterestMapper {

    public static UserInterestDto mapToUserInterestsDto(UserInterest userInterest) {
        UserInterestDto userInterestDTO = new UserInterestDto();
        userInterestDTO.setName(userInterestDTO.getName());
        userInterestDTO.setId(userInterest.getId());
        userInterestDTO.setUserId(userInterest.getUser().getUser_id());
        userInterestDTO.setAvailability(userInterest.isAvailability());
        return userInterestDTO;
    }

    public static UserInterest mapToUserInterests(UserInterestDto userInterestDTO) {
        UserInterest userInterest = new UserInterest();
        userInterest.setName(userInterestDTO.getName());
        userInterest.setId(userInterestDTO.getId());
        // Assuming User and Category objects are properly set in the DTO
        User user = new User();
        user.setUser_id(userInterestDTO.getUserId());
        userInterest.setUser(user);

        Category category = new Category();
        category.setCategory_id(userInterestDTO.getCategoryId());

        userInterest.setAvailability(userInterestDTO.isAvailability());
        return userInterest;
    }

    public static List<UserInterestDto> toDTOList(List<UserInterest> userInterests) {
        List<UserInterestDto> userInterestDTOList = new ArrayList<>();
        for (UserInterest userInterest : userInterests) {
            userInterestDTOList.add(mapToUserInterestsDto(userInterest));
        }
        return userInterestDTOList;
    }

    public static List<UserInterest> toEntityList(List<UserInterestDto> userInterestDTOList) {
        List<UserInterest> userInterests = new ArrayList<>();
        for (UserInterestDto userInterestDTO : userInterestDTOList) {
            userInterests.add(mapToUserInterests(userInterestDTO));
        }
        return userInterests;
    }
}

