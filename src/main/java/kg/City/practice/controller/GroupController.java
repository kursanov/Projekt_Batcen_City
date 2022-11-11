package kg.City.practice.controller;

import kg.City.practice.model.Course;
import kg.City.practice.model.Group;
import kg.City.practice.service.CourseService;
import kg.City.practice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    private  final CourseService courseService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }
    @ModelAttribute("listCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourses();
    }


    @GetMapping
    public String getAllGroups(Model model){
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups",groups);
        return "group/groups";
    }
    @GetMapping("/addGroup")
    public String addGroup(Model model){
        model.addAttribute("group",new Group());
        return "group/addGroup";
    }
    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group){
        groupService.addGroup(group, group.getCourseId());
        return "redirect:/groups";
    }
    @GetMapping("/updateGroup/{id}")
    public String updateGroup(@PathVariable Long id, Model model){
        Group group = groupService.getGroupById(id);
        model.addAttribute("group",group);
        return "group/uppdateGroup";
    }
    @PostMapping("/saveUpdateGroup")
    public String saveUpdateGroup(@ModelAttribute("group") Group group){
        System.out.println("groupgroupgroupgroup   " + group);
        groupService.updateGroup(group, group.getGroupId());
        return "redirect:/groups";
    }
    @RequestMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(groupService.getGroupById(id));
        return "redirect:/groups";
    }



}
