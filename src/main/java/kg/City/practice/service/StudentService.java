package kg.City.practice.service;

import kg.City.practice.model.Student;

import java.util.List;

public interface StudentService {


    List<Student> getAllStudent();

    void addStudent(Student student,Long groupId);

    Student getStudentById(Long id);

    void updateStudent(Student student,Long studentId);

    void deleteStudent(Student student);
}
