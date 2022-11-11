package kg.City.practice.controller;

import kg.City.practice.model.Company;
import kg.City.practice.model.Course;
import kg.City.practice.model.Group;
import kg.City.practice.model.Student;
import kg.City.practice.service.CompanyService;
import kg.City.practice.service.CourseService;
import kg.City.practice.service.GroupService;
import kg.City.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final StudentService studentService;

    @Autowired
    public CompanyController(CompanyService companyService, StudentService studentService) {
        this.companyService = companyService;
        this.studentService = studentService;
    }





    @GetMapping()
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";
    }
    @GetMapping("search{studentName}")
    public String getAllStudent(Model model, @PathVariable String studentName) {
        List<Student> students = studentService.getAllStudent();
        students.removeIf(student -> !Objects.equals(student.getStudentFirstName(), studentName));
        model.addAttribute("studentByName", students);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/addCompanies";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/updateCompany/{id}")
    public String updateCompany(@PathVariable Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company/updateCompany";
    }

    @PostMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company) {
        companyService.updateCompany(company);
        return "redirect:/companies";
    }

    @RequestMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(companyService.getCompanyById(id));
        return "redirect:/companies";
    }


}
