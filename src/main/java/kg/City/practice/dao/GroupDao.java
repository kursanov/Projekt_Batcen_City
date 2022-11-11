package kg.City.practice.dao;

import kg.City.practice.model.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAllGroups();

    void addGroup(Group group, Long courseId);

    Group getGroupById(Long id);

    void updateGroup(Group group,Long groupId);


    void deleteGroup(Group group);

}
