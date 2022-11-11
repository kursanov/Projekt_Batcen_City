package kg.City.practice.service.impl;

import kg.City.practice.dao.GroupDao;
import kg.City.practice.model.Group;
import kg.City.practice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public void addGroup(Group group, Long courseId) {
        groupDao.addGroup(group, courseId);
    }


    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void updateGroup(Group group, Long groupId) {
        groupDao.updateGroup(group, groupId);

    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);

    }
}
