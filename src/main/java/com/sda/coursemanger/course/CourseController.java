package com.sda.coursemanger.course;

import com.sda.coursemanger.course.model.Course;
import com.sda.coursemanger.course.model.CourseEnrollment;
import com.sda.coursemanger.course.model.dto.CourseDetailsDto;
import com.sda.coursemanger.course.model.dto.CourseDto;
import com.sda.coursemanger.course.model.dto.CourseEnrollmentForm;
import com.sda.coursemanger.exceptions.NotFoundException;
import com.sda.coursemanger.user.UserRepository;
import com.sda.coursemanger.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private CourseEnrollmentRepository courseEnrollmentRepository;

    public CourseController(CourseRepository courseRepository, UserRepository userRepository,
                            CourseEnrollmentRepository courseEnrollmentRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.courseEnrollmentRepository = courseEnrollmentRepository;
    }

    @GetMapping("/courses/")
    public List<CourseDto> getAllCourses() {
        return CourseMapper.mapCourseToDtoList(courseRepository.findAll());
    }

    @GetMapping("/courses/{id}")
    public CourseDetailsDto getSingleCourse(@PathVariable long id) throws NotFoundException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("course not found"));
        return CourseMapper.mapCourseToDetailsDto(course);
    }


    @PostMapping("/enrollments/")
    public CourseEnrollment enrollParticipant(@RequestBody CourseEnrollmentForm newEnrollment) throws NotFoundException {
        Course course = courseRepository.findById(newEnrollment.getCourseId())
                .orElseThrow(() -> new NotFoundException("course not found"));

        User participant = userRepository.findById(newEnrollment.getParticipantId())
                .orElseThrow(() -> new NotFoundException("course not found"));

        CourseEnrollment enrollment = new CourseEnrollment();
        enrollment.setCourse(course);
        enrollment.setParticipant(participant);
        CourseEnrollment savedEnrollment = courseEnrollmentRepository.save(enrollment);

        return savedEnrollment;
    }
}
