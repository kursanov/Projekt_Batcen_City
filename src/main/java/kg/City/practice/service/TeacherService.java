package kg.City.practice.service;

import kg.City.practice.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();

    void addTeacher(Teacher teacher,Long courseId);

    Teacher getTeacherById(Long id);

    void updateTeacher(Teacher teacher,Long teacherId);

    void deleteTeacher(Teacher teacher);
}
