package kg.City.practice.service.impl;

import kg.City.practice.dao.StudentDao;
import kg.City.practice.model.Student;
import kg.City.practice.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public void addStudent(Student student, Long groupId) {
        studentDao.addStudent(student, groupId);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student, Long studentId) {
        studentDao.updateStudent(student, studentId);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }
}
