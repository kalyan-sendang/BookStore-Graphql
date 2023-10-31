package com.tests.dbmanipulation.controller;

import com.tests.dbmanipulation.model.Student;
import com.tests.dbmanipulation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public int saveStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return student.getId();
    }
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
