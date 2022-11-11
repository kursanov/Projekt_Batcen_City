package kg.City.practice.controller;

import kg.City.practice.model.Course;
import kg.City.practice.model.Student;
import kg.City.practice.model.Teacher;
import kg.City.practice.service.CourseService;
import kg.City.practice.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    private final CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @ModelAttribute("listCourse")
    public List<Course> getAllCourse() {
        return courseService.getAllCourses();
    }

    @GetMapping
    public String getAllTeacher(Model model) {
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("teachers", teachers);
        return "teacher/teacher";
    }
    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher/addTeacher";
    }
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        teacherService.addTeacher(teacher, teacher.getCourseId());
        return "redirect:/teachers";
    }
    @GetMapping("/updateTeacher/{id}")
    public String updateTeacher(@PathVariable Long id, Model model){
        System.out.println("before update teacher");
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher" , teacher);
        System.out.println("after update teacher");
        return "teacher/updateTeacher";
    }
    @PostMapping("/saveUpdateTeacher")
    public String saveUpdateTeacher(@ModelAttribute("teacher") Teacher teacher){
        System.out.println("before save update");
        teacherService.updateTeacher(teacher, teacher.getCourseId());
        System.out.println("after save update "+ teacher.toString());
        return "redirect:/teachers";
    }
    @RequestMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(teacherService.getTeacherById(id));
        return "redirect:/teachers";
    }
}
