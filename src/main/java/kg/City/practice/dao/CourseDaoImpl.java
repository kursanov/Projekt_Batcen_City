package kg.City.practice.dao;


import kg.City.practice.model.Company;
import kg.City.practice.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final CompanyDao companyDao;

    @Autowired
    public CourseDaoImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = entityManager.createQuery("FROM  Course", Course.class).getResultList();
        Comparator<Course> comparator = (((o1, o2) -> (int) (o1.getCourseId() - o2.getCourseId())));
        courses.sort(comparator);
        return courses;
    }

    @Override
    public void addCourse(Course course, Long companyId) {
        Company company = companyDao.getCompanyById(companyId);
        course.setCompany(company);
        entityManager.persist(course);

    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public void updateCourse(Course course, Long companyId) {
        Company company = companyDao.getCompanyById(companyId);
        course.setCompany(company);
        entityManager.merge(course);

    }

    @Override
    public void deleteCourse(Course course) {
        course.setCompany(new Company());
        entityManager.remove(entityManager.contains(course) ? course : entityManager.merge(course));

    }
}
