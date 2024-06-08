package com.aaa.school.repo;

import com.aaa.school.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo  extends JpaRepository<Subject, Long> {

}
