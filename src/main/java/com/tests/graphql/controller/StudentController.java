package com.tests.graphql.controller;

import com.tests.graphql.model.Student;
import com.tests.graphql.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.createStudent(student);

    }
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
