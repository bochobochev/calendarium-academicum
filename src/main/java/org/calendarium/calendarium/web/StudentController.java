package org.calendarium.calendarium.web;

import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import static org.calendarium.calendarium.util.ParseUtil.getUuidFromString;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(value = "/{id}", produces = "application/json")
    public Student getStudent(@PathVariable(name = "id") String id) {
        Optional<Student> student = Optional.empty();
        if(getUuidFromString(id)!=null) {
            student = studentRepository.findById(getUuidFromString(id));
        }

        logger.debug("Returning student for ID:{}", id);

        return student.orElse(new Student());
    }



}
