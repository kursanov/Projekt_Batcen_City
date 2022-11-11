package kg.City.practice.dao;

import kg.City.practice.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();

    void  addStudent(Student student, Long groupId);

    Student getStudentById(Long id);

    void  updateStudent(Student student, Long groupId);

    void  deleteStudent(Student student );


}
