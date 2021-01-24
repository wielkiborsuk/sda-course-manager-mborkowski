package com.sda.coursemanger.user;

import com.sda.coursemanger.user.model.Role;
import com.sda.coursemanger.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByType(Role role);
    Optional<User> findByLogin(String login);
}
