package greet.project.config;

import greet.project.mapper.StudentsMapper;
import greet.project.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private StudentsMapper studentsMapper;

    public Config(StudentsMapper studentsMapper){
        this.studentsMapper = studentsMapper;
    }

    @Bean
    public void DatabaseInit(){
        Student student1 = new Student();
        student1.setName("Miras");
        student1.setSchool("Computer Science");
        Student student2 = new Student();
        student2.setName("Sarim");
        student2.setSchool("Computer Science");
        studentsMapper.insert(student1);
        studentsMapper.insert(student2);
    }

}
