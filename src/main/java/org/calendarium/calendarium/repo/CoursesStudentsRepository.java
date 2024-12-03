package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.CoursesStudents;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CoursesStudentsRepository extends JpaRepository<CoursesStudents, UUID> {

    @EntityGraph(attributePaths = {"course.courseType", "student.group"}, type = EntityGraph.EntityGraphType.LOAD)
    List<CoursesStudents> findByCourse_IdAndStudent_AgeGreaterThan(UUID id, Integer age);
}