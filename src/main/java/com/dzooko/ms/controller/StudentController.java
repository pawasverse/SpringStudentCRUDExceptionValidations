package com.dzooko.ms.controller;

import com.dzooko.ms.entity.Student;
import com.dzooko.ms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> allStudents = studentService.searchAllStudents();

        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){

        Student student = studentService.searchStudentById(id);

        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){

        Student savedStudent = studentService.addStudent(student);



        return  new ResponseEntity<>(savedStudent,HttpStatus.CREATED);


    }

    @PutMapping("/students/{id}")

    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@Valid @RequestBody Student student){

        Student updatedStudent = studentService.updateStudentById(id,student);

        return new ResponseEntity<>(updatedStudent,HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{id}")

    public void deleteStudent(@PathVariable Long id){

        studentService.deleteStudentById(id);
    }



}
