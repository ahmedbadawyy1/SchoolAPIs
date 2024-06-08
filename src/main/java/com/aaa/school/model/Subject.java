package com.aaa.school.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Teacher teacher;


    public Set<Student> getEnrollStudent() {
        return enrollStudent;
    }

    public void setEnrollStudent(Set<Student> enrollStudent) {
        this.enrollStudent = enrollStudent;
    }

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private  Set<Student> enrollStudent = new HashSet<>();

    public void enrollStudent(Student student) {
        enrollStudent.add(student);
    }
    private String name;

    public Subject() {
    }

    public Subject(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher ;
    }
}
