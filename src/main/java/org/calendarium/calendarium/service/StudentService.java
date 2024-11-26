package org.calendarium.calendarium.service;

import jakarta.persistence.EntityExistsException;
import org.calendarium.calendarium.core.assemblers.StudentAssembler;
import org.calendarium.calendarium.core.dto.StudentDto;
import org.calendarium.calendarium.entity.CoursesStudents;
import org.calendarium.calendarium.entity.Group;
import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.repo.CoursesStudentsRepository;
import org.calendarium.calendarium.repo.GroupRepository;
import org.calendarium.calendarium.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CoursesStudentsRepository coursesStudentsRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    StudentAssembler studentAssembler;

    @Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = EntityExistsException.class,
            rollbackForClassName = "IllegalArgumentException", noRollbackForClassName = "EntityExistsException")
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Transactional(rollbackFor = IllegalArgumentException.class, rollbackForClassName = "IllegalArgumentException")
    public Optional<Student> update(UUID studentId, Student student){
        int rowsUpdated = studentRepository.update(student.getFirstName()
                , student.getLastName()
                , student.getAge()
                , student.getGroup(),
                studentId
        );

        return studentRepository.findById(studentId);
    }

    @Transactional(rollbackFor = IllegalArgumentException.class, rollbackForClassName = "IllegalArgumentException")
    public Optional<Student> delete(UUID studentId){
        Optional <Student> deletedStudent = studentRepository.findById(studentId);
        deletedStudent.ifPresent(student -> studentRepository.delete(student));

        return deletedStudent;
    }

    public long count(){
        return studentRepository.count();
    }


    public Optional<Student> findById(UUID studentId) {
        return studentRepository.findById(studentId);
    }

    public Optional<List<Student>> findByGroupNumber(Integer groupNumber) {
        Optional<Group> group = groupService.getGroupByGroupNumber(groupNumber);
        Optional<List<Student>> studentsInGroup = Optional.empty();
        if(group.isPresent()){
            studentsInGroup = Optional.ofNullable(studentRepository.findByGroup(group.get()));
        }

        return studentsInGroup;
    }

    public Optional<List<CoursesStudents>> getStudentsOlderThanAgeInCourse(Integer age, UUID courseId){
//        return Optional.ofNullable(studentRepository.findByAgeGreaterThanAndCoursesEnrolments_Course_Id(age, courseId));
        return Optional.ofNullable(coursesStudentsRepository.findByCourse_IdAndStudent_AgeGreaterThan(courseId,age));
    }
}
