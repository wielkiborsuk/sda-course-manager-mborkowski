package com.sda.coursemanger.lesson;

import com.sda.coursemanger.lesson.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
