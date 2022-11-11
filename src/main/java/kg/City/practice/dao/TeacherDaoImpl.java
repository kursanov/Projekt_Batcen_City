package kg.City.practice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kg.City.practice.model.Course;
import kg.City.practice.model.Group;
import kg.City.practice.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final CourseDao courseDao;

    public TeacherDaoImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = entityManager.createQuery("FROM  Teacher", Teacher.class).getResultList();
        Comparator<Teacher> comparator = (((o1, o2) -> (int) (o1.getTeacherId() - o2.getTeacherId())));
        teachers.sort(comparator);
        return teachers;
    }

    @Override
    public void addTeacher(Teacher teacher, Long courseId) {
        Course course = courseDao.getCourseById(courseId);
        teacher.setCourse(course);
        entityManager.persist(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public void updateTeacher(Teacher teacher,Long courseId) {
        Course course = courseDao.getCourseById(courseId);
        teacher.setCourse(course);
        entityManager.merge(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        Course course = new Course();
        teacher.setCourse(course);
        entityManager.remove(entityManager.contains(teacher) ? teacher : entityManager.merge(teacher));
    }
}
