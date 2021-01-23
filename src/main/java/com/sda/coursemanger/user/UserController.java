package com.sda.coursemanger.user;

import com.sda.coursemanger.exceptions.NotFoundException;
import com.sda.coursemanger.user.model.Role;
import com.sda.coursemanger.user.model.User;
import com.sda.coursemanger.user.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/")
    public List<UserDto> getUsers() {
        return UserMapper.mapLoessonBlockToDtoList(userRepository.findAll());
    }

    @GetMapping(value = "/users/", params = "type")
    public List<UserDto> getUsersByType(@RequestParam("type") String type) {
        Role role = Role.valueOf(type);
        return UserMapper.mapLoessonBlockToDtoList(userRepository.findByType(role));
    }


    @GetMapping("/users/{id}")
    public UserDto getSingleUser(@PathVariable Long id) throws NotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user not found"));

        return UserMapper.mapUserToDto(user);
    }
}
