package org.calendarium.calendarium.service;

import org.calendarium.calendarium.entity.CourseType;
import org.calendarium.calendarium.repo.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class CourseTypesService {
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    public Optional<CourseType> getCourseTypeByName(String courseTypeName){
        List<CourseType> courseTypesByName = courseTypeRepository.findByName(courseTypeName);
        if (courseTypesByName == null || courseTypesByName.isEmpty()){
            return Optional.empty();
        }

        return Optional.ofNullable(courseTypesByName.get(0));
    }
}
