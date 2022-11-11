package kg.City.practice.service;

import kg.City.practice.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CourseService {

    List<Course> getAllCourses();

    void  addCourse(Course course, Long courseId);

    Course getCourseById(Long id);

    void updateCourse(Course course, Long companyId);

    void deleteCourse(Course course);
}
