package com.aaa.school.service;

import com.aaa.school.model.Subject;
import com.aaa.school.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepo subjectRepo;

    // get All Subjects
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    //get Subject By id
    public Subject getSubjectById(Long id) {
        return subjectRepo.findById(id).get();
    }

    // create Subject
    public Subject createSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    // delete subject
    public void deleteSubject(Long id) {
        subjectRepo.deleteById(id);
    }


}
