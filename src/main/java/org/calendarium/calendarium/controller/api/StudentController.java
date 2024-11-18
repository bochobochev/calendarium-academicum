package org.calendarium.calendarium.controller.api;

import org.calendarium.calendarium.core.dto.StudentDto;
import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        if(getUuidFromString(id)!=null) {
            student = Optional.of(studentService.findById(getUuidFromString(id)).orElse(new Student()));
        }
        logger.debug("Returning student for ID:{}", id);

        return new ResponseEntity<>(student.orElse(new Student()), HttpStatus.OK);
    }

    @GetMapping(value = "/count", produces = "application/json")
    public Long countStudents() {
        Optional <Long> studentsCount = Optional.of(studentService.count());

        return studentsCount.orElse(-1L);
    }

    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Optional<Student> createdStudent =  Optional.ofNullable(studentService.save(student));
        return new ResponseEntity<>(createdStudent.orElse(new Student()), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") String id, @RequestBody Student student){
        Optional<Student> updatedStudent =  Optional.empty();
        if(getUuidFromString(id)!=null) {
            updatedStudent = studentService.update(getUuidFromString(id), student);
        }

        return new ResponseEntity<>(updatedStudent.orElse(new Student()), HttpStatus.OK);
    }

}
