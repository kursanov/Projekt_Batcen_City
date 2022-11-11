package kg.City.practice.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kg.City.practice.model.Course;
import kg.City.practice.model.Group;
import kg.City.practice.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public  class StudentDaoImpl implements StudentDao{
    @PersistenceContext
    private EntityManager entityManager;

    private final GroupDao groupDao;

    public StudentDaoImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public List<Student> getAllStudent() {
        List<Student> students = entityManager.createQuery("FROM  Student", Student.class).getResultList();
        Comparator<Student> comparator = (((o1, o2) -> (int) (o1.getStudentId() - o2.getStudentId())));
        students.sort(comparator);
        return students;
    }

    @Override
    public void addStudent(Student student, Long groupId) {
        Group group = groupDao.getGroupById(groupId);
        student.setGroups(group);
        entityManager.persist(student);

    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public void updateStudent(Student student, Long groupId) {
        Group group = groupDao.getGroupById(groupId);
        student.setGroups(group);
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Student student) {
        System.out.println(student);
        Group group = new Group();
        student.setGroups(group);
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));

    }
}
