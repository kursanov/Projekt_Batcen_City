package kg.City.practice.controller;


import jakarta.persistence.EntityManager;
import kg.City.practice.model.Student;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Pack;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private EntityManager entityManager;

    @RequestMapping
    public String getHello() {
        return "index";
    }



    @DeleteMapping("/student/{id}/remove")
    public void student(@PathVariable Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}

