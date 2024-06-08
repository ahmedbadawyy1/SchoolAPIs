package com.aaa.school.service;

import com.aaa.school.model.Student;
import com.aaa.school.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    // get all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // get student by id
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    // delete student by id
    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    // create student
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    // update Student
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }


}
