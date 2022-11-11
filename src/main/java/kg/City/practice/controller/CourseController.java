package kg.City.practice.controller;

import kg.City.practice.model.Company;
import kg.City.practice.model.Course;
import kg.City.practice.service.CompanyService;
import kg.City.practice.service.CourseService;
import kg.City.practice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    private final GroupService groupService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService, GroupService groupService) {
        this.courseService = courseService;
        this.companyService = companyService;
        this.groupService = groupService;
    }

    @ModelAttribute("listCompany")
    public List<Company> getAllCompany() {
        return companyService.getAllCompanies();
    }
//    @GetMapping("/courseDetail/{courseId}")
//    public String getAllGroupForCourse(@PathVariable Long courseId, Model model){
//        List<Groups_Courses> groups = groupService.getAllGroupForCourse(courseId);
//        model.addAttribute("listGroupsForCourse", groups);
//        return "course/groupsForCourseDetail";
//    }


    @GetMapping
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "course/course";

    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course, course.getCompanyId());
        return "redirect:/courses";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourses(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "course/uppdateCourse";
    }

    @PostMapping("saveUpdateCourse")
    public String saveUpdateCourse(@ModelAttribute("course") Course course, Company company) {
        courseService.updateCourse(course, course.getCompanyId() );
        return "redirect:/courses";
    }

    @RequestMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(courseService.getCourseById(id));
        return "redirect:/courses";
    }
}
