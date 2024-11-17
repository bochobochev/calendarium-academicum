package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<Courses, UUID> {
}