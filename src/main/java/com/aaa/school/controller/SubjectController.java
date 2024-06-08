package com.aaa.school.controller;

import com.aaa.school.model.Student;
import com.aaa.school.model.Subject;
import com.aaa.school.model.Teacher;
import com.aaa.school.service.StudentService;
import com.aaa.school.service.SubjectService;
import com.aaa.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }


    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);
        subject.enrollStudent(student);
        return subjectService.createSubject(subject);
    }


    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        subject.assignTeacher(teacher);
        return subjectService.createSubject(subject);
    }

}
