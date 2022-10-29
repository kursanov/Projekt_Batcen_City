package kg.City.practice.dao;

import kg.City.practice.model.Company;
import kg.City.practice.model.Course;

public interface CourseDao {

    void updateCourse(Course course);

    void deleteCourse(Course course);

    void  addCompany(Company company);
}
