package com.sda.coursemanger.lesson;

import com.sda.coursemanger.exceptions.NotFoundException;
import com.sda.coursemanger.lesson.model.LessonBlock;
import com.sda.coursemanger.lesson.model.dto.LessonBlockUpdateForm;
import com.sda.coursemanger.user.UserRepository;
import com.sda.coursemanger.user.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LessonControllerTest {

    @Mock
    UserRepository userRepository;

    @Mock
    LessonBlockRepository lessonBlockRepository;

    @InjectMocks
    LessonController lessonController;

    @Test
    void updateLessonBlockFailToFindUser() {
        LessonBlockUpdateForm lessonBlockUpdateForm = new LessonBlockUpdateForm();
        lessonBlockUpdateForm.setTeacherId(1);
        lessonBlockUpdateForm.setSubject("subject");

        LessonBlock lessonBlock = new LessonBlock();

        when(lessonBlockRepository.findById(1l)).thenReturn(Optional.of(lessonBlock));

        assertThrows(NotFoundException.class, () -> {
            lessonController.updateLessonBlock(1l, lessonBlockUpdateForm);
        });
    }

    @Test
    void updateLessonBlockSuccess() throws NotFoundException {
        LessonBlockUpdateForm lessonBlockUpdateForm = new LessonBlockUpdateForm();
        lessonBlockUpdateForm.setTeacherId(1);
        lessonBlockUpdateForm.setSubject("subject");

        LessonBlock lessonBlock = new LessonBlock();
        lessonBlock.setLessons(new ArrayList<>());

        when(lessonBlockRepository.findById(1l)).thenReturn(Optional.of(lessonBlock));
        when(userRepository.findById(1l)).thenReturn(Optional.of(mock(User.class)));

        when(lessonBlockRepository.save(any())).thenReturn(lessonBlock);

        lessonController.updateLessonBlock(1l, lessonBlockUpdateForm);

        verify(lessonBlockRepository).save(lessonBlock);
    }
}