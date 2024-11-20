package org.calendarium.calendarium.controller.api;

import org.calendarium.calendarium.entity.CourseType;
import org.calendarium.calendarium.service.CourseTypesService;
import org.calendarium.calendarium.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;
    @Autowired
    CourseTypesService courseTypesService;



    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<Long> countCoursesByTypeId(@RequestParam(name = "course_type") String courseTypeName) {
        Optional<CourseType> optionalCourseType = courseTypesService.getCourseTypeByName(courseTypeName);
        Optional<Long> studentsCount = Optional.empty();
        if(optionalCourseType.isPresent()) {
            studentsCount = coursesService.countCoursesByType(optionalCourseType.get());
        }

        return new ResponseEntity<>(studentsCount.orElse(-1L), HttpStatus.OK);
    }

}
