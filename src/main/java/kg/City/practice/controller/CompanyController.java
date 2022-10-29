package kg.City.practice.controller;

import kg.City.practice.model.Company;
import kg.City.practice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping()
    public String getCompanies(Model model){
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("company",companies);
        return "companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model){
        model.addAttribute("company", new Company());
        return "addCompanies";
    }
    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company")Company company){
        companyService.addCompany(company);
        return "redirect:/getAllCompanies";
    }

    @GetMapping("/updateCompany")
    public String updateCompany(@RequestParam("company") long id, Model model){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company",company);
        return "updateCompany";
    }
    @PostMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company){
        companyService.updateCompany(company);
        return "redirect:/getAllCompanies";
    }
    @RequestMapping("/deleteCompany")
    public String deleteCompany(@RequestParam("companyId") long id){
        companyService.deleteCompany(companyService.getCompanyById(id));
        return "redirect:/getAllCompanies";
    }


}
