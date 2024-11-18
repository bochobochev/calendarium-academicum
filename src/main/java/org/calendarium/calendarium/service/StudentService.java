package org.calendarium.calendarium.service;

import jakarta.persistence.EntityExistsException;
import org.calendarium.calendarium.core.assemblers.StudentAssembler;
import org.calendarium.calendarium.core.dto.StudentDto;
import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    StudentAssembler studentAssembler;

    @Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException", noRollbackForClassName = "EntityExistsException")
    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> update(UUID studentId, Student student){
        int rowsUpdated = studentRepository.update(student.getFirstName()
                , student.getLastName()
                , student.getAge()
                , student.getGroup(),
                studentId
        );
        return studentRepository.findById(studentId);
    }

    public long count(){
        return studentRepository.count();
    }


    public Optional<Student> findById(UUID studentId) {
        return studentRepository.findById(studentId);
    }
}
