package com.sda.coursemanger.user;

import com.sda.coursemanger.user.model.User;
import com.sda.coursemanger.user.model.dto.UserDto;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/")
    public List<UserDto> getUsers() {
        return UserMapper.mapLoessonBlockToDtoList(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public UserDto getSingleUser(@PathVariable Long id) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user not found"));

        return UserMapper.mapUserToDto(user);
    }
}
