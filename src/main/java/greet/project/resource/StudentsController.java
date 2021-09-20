package greet.project.resource;

import com.google.gson.Gson;
import greet.project.mapper.StudentsMapper;
import greet.project.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.List;

@Controller
public class StudentsController {
    private StudentsMapper studentsMapper;

    public StudentsController(StudentsMapper studentsMapper){
        this.studentsMapper = studentsMapper;
    }

    @GetMapping("/all")
    public List<Student> getAll(){
        List<Student> students = studentsMapper.findAll();
        return students;
    }

    @PostMapping(value = "/addstudent")
    public String addItem(@RequestParam(name = "name") String name,
                                          @RequestParam(name = "school") String school){
        Student student = new Student();
        student.setName(name);
        student.setSchool(school);
        studentsMapper.insert(student);
        return "redirect:/homepage";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String toDelete(@PathVariable(name="id") Long id, Model model){
        studentsMapper.delete(id);
        return "redirect:/homepage";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "user") String user,
                                 @RequestParam(name = "password") String password, Model model){
        model.addAttribute("CURRENT_USER", getUser());
        if(user.equals("admin") && password.equals("admin")){
            return "redirect:/homepage";
        }
        return "redirect:/login";
    }

    @GetMapping(value="/login")
    public String loginPage(Model model){
        model.addAttribute("CURRENT_USER", getUser());
        return "login";
    }

    @GetMapping(value="/logout")
    public String logout(Model model){
        model.addAttribute("CURRENT_USER", getUser());
        return "login";
    }

    @GetMapping(value = "/homepage")
    public String homepage(Model model){
        model.addAttribute("CURRENT_USER", getUser());
        List<Student> students = studentsMapper.findAll();
        model.addAttribute("students", students);
        return "homepage";
    }

    @GetMapping(value = "/navbar")
    public String home(Model model){
        model.addAttribute("CURRENT_USER", getUser());
        List<Student> students = studentsMapper.findAll();
        model.addAttribute("students", students);
        return "homepage";
    }

    @GetMapping(value = "/ajaxReadReviews")
    public List<Student> ajaxLoad(){
        List<Student> students = studentsMapper.findAll();
        Gson gson = new Gson();
        String result = gson.toJson(students);
        return students;
    }

    private String getUser(){
        return "admin";
    }
}
