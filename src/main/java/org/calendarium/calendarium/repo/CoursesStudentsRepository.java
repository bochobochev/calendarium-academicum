package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.CoursesStudents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesStudentsRepository extends JpaRepository<CoursesStudents, UUID> {
}