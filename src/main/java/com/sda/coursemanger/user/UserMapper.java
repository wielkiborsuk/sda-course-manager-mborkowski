package com.sda.coursemanger.user;

import com.sda.coursemanger.user.model.User;
import com.sda.coursemanger.user.model.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<UserDto> mapLoessonBlockToDtoList(List<User> users) {
        return users.stream()
                .map(UserMapper::mapUserToDto)
                .collect(Collectors.toList());
    }

    public static UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setType(user.getType().name());
        userDto.setName(String.format("%s %s", user.getFirstName(), user.getLastName()));

        return userDto;
    }
}
