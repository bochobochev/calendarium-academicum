package org.calendarium.calendarium.controller.api;


import org.calendarium.calendarium.entity.Teacher;
import org.calendarium.calendarium.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.calendarium.calendarium.util.ParseUtil.getUuidFromString;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    TeacherService teacherService;

    private static final Logger logger = LoggerFactory.getLogger(TeachersController.class);

    @GetMapping(value = "/count", produces = "application/json")
    public Long countTeachers() {
        Optional<Long> teachersCount = Optional.of(teacherService.count());

        return teachersCount.orElse(-1L);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Teacher> getTeacher(@PathVariable(name = "id") String id) {
        Optional<Teacher> teacher = Optional.empty();
        if(getUuidFromString(id)!=null) {
            teacher = teacherService.findById(getUuidFromString(id));
        }

        return new ResponseEntity<>(teacher.orElse(Teacher.builder().build()),  HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        Optional<Teacher> createdTeacher = Optional.ofNullable(teacherService.save(teacher));

        return  new ResponseEntity<>(createdTeacher.orElse(Teacher.builder().build()), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Teacher> updateTeacher(@PathVariable(name = "id") String id, @RequestBody Teacher teacher){
        Optional<Teacher> updatedTeacher = Optional.empty();
        if(getUuidFromString(id)!=null) {
            updatedTeacher = teacherService.update(getUuidFromString(id), teacher);
        }

        return  new ResponseEntity<>(updatedTeacher.orElse(Teacher.builder().build()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Teacher> removeTeacher(@PathVariable(name = "id") String id){
        Optional<Teacher> deletedTeacher =  Optional.empty();
        if(getUuidFromString(id)!=null) {
            deletedTeacher = teacherService.delete(getUuidFromString(id));
        }

        return new ResponseEntity<>(deletedTeacher.orElse(Teacher.builder().build()), HttpStatus.NO_CONTENT);
    }

}
