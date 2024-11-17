package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}