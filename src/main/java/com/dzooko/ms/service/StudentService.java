package com.dzooko.ms.service;

import com.dzooko.ms.entity.Student;

import java.util.List;

public interface StudentService {

     Student searchStudentById(Long id);

     List<Student> searchAllStudents();

     Student addStudent(Student student);

     Student updateStudentById(Long id, Student student);

     void deleteStudentById(Long id);


}
