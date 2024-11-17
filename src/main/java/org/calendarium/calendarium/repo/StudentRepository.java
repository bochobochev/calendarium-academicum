package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}