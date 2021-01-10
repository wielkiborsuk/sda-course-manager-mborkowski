package com.sda.coursemanger.course;

import com.sda.coursemanger.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
