package org.calendarium.calendarium.service;

import jakarta.persistence.EntityExistsException;
import org.calendarium.calendarium.entity.Teacher;
import org.calendarium.calendarium.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException", noRollbackForClassName = "EntityExistsException")
    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public long count(){
        return teacherRepository.count();
    }

}
