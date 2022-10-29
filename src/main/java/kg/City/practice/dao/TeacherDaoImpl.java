package kg.City.practice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kg.City.practice.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher) ? teacher : entityManager.merge(teacher));
    }
}
