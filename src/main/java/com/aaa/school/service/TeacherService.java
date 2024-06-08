package com.aaa.school.service;

import com.aaa.school.model.Teacher;
import com.aaa.school.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    // get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    // get teacher by id
    public Teacher getTeacherById(Long id) {
        return teacherRepo.findById(id).get();
    }

    // create new teacher
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    // delete  teacher
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }
}
