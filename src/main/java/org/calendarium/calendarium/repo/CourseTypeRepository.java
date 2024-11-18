package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseTypeRepository extends JpaRepository<CourseType, UUID> {
}