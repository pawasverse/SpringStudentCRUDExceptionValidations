package com.dzooko.ms.service;

import com.dzooko.ms.entity.Student;
import com.dzooko.ms.exception.StudentNotFoundException;
import com.dzooko.ms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired

    private StudentRepository studentRepository;


    @Override
    public Student searchStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException("sorry, student not found")
        );

        return student;

    }

    @Override
    public List<Student> searchAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students;


    }

    @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentById(Long id, Student student) {



        Student existingStudent =  studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException("sorry, student not found")
        );

        existingStudent.setLastName(student.getLastName());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);


    }

    @Override
    public void deleteStudentById(Long id) {
         studentRepository.findById(id).orElseThrow(
                 ()-> new StudentNotFoundException("sorry, student not found")
         );

         studentRepository.deleteById(id);
    }
}
