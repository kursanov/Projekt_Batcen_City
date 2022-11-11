package kg.City.practice.service.impl;

import kg.City.practice.dao.TeacherDao;
import kg.City.practice.model.Teacher;
import kg.City.practice.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl  implements TeacherService {

    private final TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }


    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public void addTeacher(Teacher teacher, Long courseId) {
        teacherDao.addTeacher(teacher, courseId);

    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher, Long teacherId) {
        teacherDao.updateTeacher(teacher,teacherId);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);

    }
}
