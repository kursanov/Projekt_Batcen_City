package kg.City.practice.dao;

import kg.City.practice.model.Teacher;

import java.util.List;

public interface TeacherDao {


    List<Teacher> getAllTeacher();

    void  addTeacher(Teacher teacher, Long courseId);

    Teacher getTeacherById(Long id);

    void updateTeacher(Teacher teacher, Long courseId);

    void deleteTeacher(Teacher teacher);
}
