package org.calendarium.calendarium.controller.api;

import org.calendarium.calendarium.entity.CoursesStudents;
import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.calendarium.calendarium.util.ParseUtil.getUuidFromString;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") String id) {
        Optional<Student> student = Optional.empty();
        logger.debug("Returning student for ID: {}", id);
        if(getUuidFromString(id)!=null) {
            student = Optional.of(studentService.findById(getUuidFromString(id)).orElse(new Student()));
        }

        return new ResponseEntity<>(student.orElse(new Student()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudentsInGroup(@RequestParam(name = "group_number") Integer groupNumber) {
        Optional<List<Student>> student = Optional.empty();
        logger.debug("Returning students for group: {}", groupNumber);
        if(groupNumber!=null) {
            student = studentService.findByGroupNumber(groupNumber);
        }

        return new ResponseEntity<>(student.orElse(new ArrayList<Student>()), HttpStatus.OK);
    }
    @GetMapping(path = "/in-course-older-than")
    public ResponseEntity<List<CoursesStudents>> getStudentsOlderTanAgeInCourse(@RequestParam(name = "course_id") UUID courseId, @RequestParam(name = "age") Integer age) {
        Optional<List<CoursesStudents>> student = Optional.empty();
        logger.debug("Returning students for courseId: {}, older than: {}", courseId, age);
        if(age!=null && courseId!=null) {
            student = studentService.getStudentsOlderThanAgeInCourse(age, courseId);
        }

        return new ResponseEntity<>(student.orElse(new ArrayList<CoursesStudents>()), HttpStatus.OK);
    }

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<Long> countStudents() {
        Optional <Long> studentsCount = Optional.of(studentService.count());
        logger.debug("Number of students: {}", studentsCount);

        return new ResponseEntity<>(studentsCount.orElse(-1L), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        logger.debug("Saving student: {}", student);
        Optional<Student> createdStudent =  Optional.ofNullable(studentService.save(student));

        return new ResponseEntity<>(createdStudent.orElse(new Student()), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") String id, @RequestBody Student student){
        Optional<Student> updatedStudent =  Optional.empty();
        logger.debug("Updating student with ID: {}", id);
        if(getUuidFromString(id)!=null) {
            updatedStudent = studentService.update(getUuidFromString(id), student);
        }

        return new ResponseEntity<>(updatedStudent.orElse(new Student()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Student> removeStudent(@PathVariable(name = "id") String id){
        logger.debug("Deleting student with ID: {}", id);
        Optional<Student> deletedStudent =  Optional.empty();
        if(getUuidFromString(id)!=null) {
            deletedStudent = studentService.delete(getUuidFromString(id));
        }

        return new ResponseEntity<>(deletedStudent.orElse(new Student()), HttpStatus.NO_CONTENT);
    }

}
