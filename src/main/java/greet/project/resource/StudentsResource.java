package greet.project.resource;

import greet.project.mapper.StudentsMapper;
import greet.project.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/students")
@CrossOrigin
public class StudentsResource {
    private StudentsMapper studentsMapper;

    public StudentsResource(StudentsMapper studentsMapper){
        this.studentsMapper = studentsMapper;
    }

    @GetMapping("/all")
    public List<Student> getAll(){
        List<Student> students = studentsMapper.findAll();
        return students;
    }

    @GetMapping(value = "/addstudent")
    public List<Student> addItem(){
        Student student = new Student();
        student.setName("Sarim");
        student.setSchool("Computer");
        studentsMapper.insert(student);
        return studentsMapper.findAll();
    }

    @GetMapping(value = "/deleteStudent/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    public List<Student> toDelete(@PathVariable(name="id") Long id, Model model){
        studentsMapper.delete(id);
        return studentsMapper.findAll();
    }

//    @GetMapping(value = "/deleteStudent/{id}")
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
//    public String toDelete(@PathVariable(name="id") Long id, Model model){
//        model.addAttribute("CURRENT_USER", getUser());
//        itemDB.deleteItem(id);
//        return "redirect:/index";
//    }
}
