package org.calendarium.calendarium.service;

import jakarta.persistence.EntityExistsException;
import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException", noRollbackForClassName = "EntityExistsException")
    public Student save(Student student){
        return studentRepository.save(student);
    }

    public int count(){
        return studentRepository.findAll().size();
    }


}
