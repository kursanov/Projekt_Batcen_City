package kg.City.practice.service;

import kg.City.practice.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();

    void addGroup(Group group,Long courseId);

    Group getGroupById(Long id);

    void updateGroup(Group group,Long groupId);

    void deleteGroup(Group group);
}
