package org.calendarium.calendarium.service;

import jakarta.persistence.EntityExistsException;
import org.calendarium.calendarium.entity.Teacher;
import org.calendarium.calendarium.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

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

    @Transactional(rollbackFor = IllegalArgumentException.class, rollbackForClassName = "IllegalArgumentException")
    public Optional<Teacher> update(UUID teacherId, Teacher teacher){
         teacherRepository.update(teacher.getFirstName(), teacher.getLastName(), teacher.getAge(), teacherId);

        return teacherRepository.findById(teacherId);
    }

    public long count(){
        return teacherRepository.count();
    }

    public Optional<Teacher> findById(UUID teacherId){
        return teacherRepository.findById(teacherId);
    }


    public Optional<Teacher> delete(UUID teacherId) {
        Optional <Teacher> deletedTeacher = teacherRepository.findById(teacherId);
        deletedTeacher.ifPresent(teacher -> teacherRepository.delete(teacher));

        return deletedTeacher;
    }
}
