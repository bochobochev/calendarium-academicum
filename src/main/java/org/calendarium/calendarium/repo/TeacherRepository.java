package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    @Transactional
    @Modifying
    @Query("update Teacher t set t.firstName = ?1, t.lastName = ?2, t.age = ?3 where t.teachersId = ?4")
    int update(String firstName, String lastName, Integer age, UUID teachersId);
}