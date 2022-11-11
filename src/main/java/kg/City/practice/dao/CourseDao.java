package kg.City.practice.dao;

import kg.City.practice.model.Company;
import kg.City.practice.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourse();

    void  addCourse( Course course , Long courseId);

    Course getCourseById(Long id);


    void updateCourse(Course course, Long companyId);

    void deleteCourse(Course course);


}
