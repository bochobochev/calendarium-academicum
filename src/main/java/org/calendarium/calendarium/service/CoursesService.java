package org.calendarium.calendarium.service;

import org.calendarium.calendarium.entity.CourseType;
import org.calendarium.calendarium.repo.CourseTypeRepository;
import org.calendarium.calendarium.repo.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    public Optional<Long> countCoursesByType(CourseType courseType){

        return Optional.of(coursesRepository.countByCourseType(courseType));
    }
}
