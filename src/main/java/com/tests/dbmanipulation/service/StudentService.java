package com.tests.dbmanipulation.service;

import com.tests.dbmanipulation.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    //get all students
    public List<Student> getAllStudents(){
        return students;
    }
    //get single student
    public Student getStudentById(int id){
        return students.stream()
                .filter(student ->student.getId() == (id))
                .findFirst()
                .orElse(null);
    }
    //create student
    public Student createStudent(Student student){
        students.add(student);
        return student;
    }
    public Student updateStudent(int id , Student student){
        Student existingStudent = getStudentById(id);
        if(existingStudent!= null){
            existingStudent.setName(student.getName());
           existingStudent.setEmail(student.getEmail());
        }
        return existingStudent;
    }
    public void deleteStudent(int id){
        students.removeIf(student -> student.getId() == id);
    }

}
