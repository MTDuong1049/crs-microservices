package vn.edu.crs.course_service.controller;

import org.springframework.web.bind.annotation.*;
import vn.edu.crs.course_service.entity.Course;
import vn.edu.crs.course_service.repository.CourseRepository;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
}