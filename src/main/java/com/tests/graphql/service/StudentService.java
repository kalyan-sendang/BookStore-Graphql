package com.tests.graphql.service;

import com.tests.graphql.model.Student;
import com.tests.graphql.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //get all students
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    //get single student
    public Student getStudentById(Long id){
        Optional<Student> student = studentRepo.findById(id);
        return student.orElse(null);
    }
    //create student
    public Student createStudent(Student student){
        return studentRepo.save(student);
    }
    public Student updateStudent(Long id , Student student){
        Student existingStudent = getStudentById(id);
        if(existingStudent!= null){
            existingStudent.setName(student.getName());
           existingStudent.setEmail(student.getEmail());
            return existingStudent;
        }else{
            return null;
        }

    }
    public void deleteStudent(Long id){
        Student student = getStudentById(id);
        if(student != null){
            studentRepo.delete(student);
        }
    }

}
