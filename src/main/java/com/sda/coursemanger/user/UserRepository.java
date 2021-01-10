package com.sda.coursemanger.user;

import com.sda.coursemanger.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
