package kg.City.practice.dao;


import kg.City.practice.model.Company;
import kg.City.practice.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CourseDaoImpl implements  CourseDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);

    }

    @Override
    public void deleteCourse(Course course) {
        entityManager.remove(entityManager.contains(course) ? course : entityManager.merge(course));

    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }
}
