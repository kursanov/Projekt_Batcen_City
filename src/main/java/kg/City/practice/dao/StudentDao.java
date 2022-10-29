package kg.City.practice.dao;

import kg.City.practice.model.Student;

import java.util.List;

public interface StudentDao {

    void updateStudent(Student student);
    void createStudent(Student student);
    List<Student> getAllStudents(Student student);
    void deleteStudent(Student student);
}
