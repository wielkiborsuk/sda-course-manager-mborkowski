package com.sda.coursemanger.lesson;

import com.sda.coursemanger.exceptions.NotFoundException;
import com.sda.coursemanger.lesson.model.LessonBlock;
import com.sda.coursemanger.lesson.model.dto.LessonBlockDetailsDto;
import com.sda.coursemanger.lesson.model.dto.LessonBlockUpdateForm;
import com.sda.coursemanger.user.UserRepository;
import com.sda.coursemanger.user.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LessonController {

    private LessonBlockRepository lessonBlockRepository;
    private UserRepository userRepository;

    public LessonController(LessonBlockRepository lessonBlockRepository,
                            UserRepository userRepository) {
        this.lessonBlockRepository = lessonBlockRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/lessonblocks/{id}")
    public LessonBlockDetailsDto getSingleLessonBlock(@PathVariable Long id) throws NotFoundException {
        LessonBlock lessonBlock = lessonBlockRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("lesson block not found"));

        return LessonMapper.mapLessonBlockToDto(lessonBlock);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/lessonblocks/{id}")
    public LessonBlockDetailsDto updateLessonBlock(@PathVariable Long id,
                                                   @RequestBody @Valid LessonBlockUpdateForm newLessonBlock) throws NotFoundException {
        LessonBlock lessonBlock = lessonBlockRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("lesson block not found"));

        lessonBlock.setSubject(newLessonBlock.getSubject());

        User teacher = userRepository.findById(newLessonBlock.getTeacherId())
                .orElseThrow(() -> new NotFoundException("teacher user not found"));

        lessonBlock.setTeacher(teacher);

        LessonBlock updatedLessonBlock = lessonBlockRepository.save(lessonBlock);

        return LessonMapper.mapLessonBlockToDto(updatedLessonBlock);
    }
}
