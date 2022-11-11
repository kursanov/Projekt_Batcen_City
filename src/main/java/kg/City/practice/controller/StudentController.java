package kg.City.practice.controller;

import kg.City.practice.model.Group;
import kg.City.practice.model.Student;
import kg.City.practice.service.GroupService;
import kg.City.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/students")
public class StudentController {

    private  final StudentService studentService;

    private  final GroupService groupService;

    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }
    @ModelAttribute("listGroup")
    public List<Group> getAllGroup(){
        return groupService.getAllGroups();
    }
    @GetMapping
    public String getAllStudent(Model model){
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students",students);
        return "student/student";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "student/addStudent";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.addStudent(student, student.getGroupId());
        return "redirect:/students";
    }
    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id,Model model){
        System.out.println("before update ");
        Student student = studentService.getStudentById(id);
        model.addAttribute("student" , student);
        System.out.println("after update");
        return "student/updateStudent";
    }
    @PostMapping("/saveUpdateStudent")
    public String saveUpdateStudent(@ModelAttribute("student") Student student){
        System.out.println("before save update " + student.toString());
        studentService.updateStudent(student, student.getStudentId());
        System.out.println("after save update");
        return "redirect:/students";
    }
    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(studentService.getStudentById(id));
        return "redirect:/students";
    }
}
