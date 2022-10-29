package kg.City.practice.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kg.City.practice.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void createStudent(Student student) {

    }

    @Override
    public List<Student> getAllStudents(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student)) ;

    }
}
