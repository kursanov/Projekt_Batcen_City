package kg.City.practice.dao;

import kg.City.practice.model.Course;
import kg.City.practice.model.Group;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final CourseDao courseDao;

    @Autowired
    public GroupDaoImpl( CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = entityManager.createQuery("FROM  Group", Group.class).getResultList();
        Comparator<Group> comparator = (((o1, o2) -> (int) (o1.getGroupId() - o2.getGroupId())));
        groups.sort(comparator);
        return groups;
    }

    @Override
    public void addGroup(Group group, Long courseId) {
        Course course = courseDao.getCourseById(courseId);
        System.out.println("course.getCourseId()" + course.getCourseId());
        group.setCourses(Collections.singletonList(course));
        entityManager.persist(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    public void updateGroup(Group group, Long courseId) {
        Course course = courseDao.getCourseById(courseId);
        group.setCourses(Collections.singletonList(course));
        entityManager.merge(group);
    }

    @Override
    public void deleteGroup(Group group) {
        group.setCourses(new ArrayList<>());
        entityManager.remove(entityManager.contains(group) ? group : entityManager.merge(group));
    }
}
