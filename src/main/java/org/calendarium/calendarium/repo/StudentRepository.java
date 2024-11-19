package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.Group;
import org.calendarium.calendarium.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Transactional
    @Modifying
    @Query("update Student s set s.firstName = ?1, s.lastName = ?2, s.age = ?3, s.group = ?4 where s.studentId = ?5")
    int update(@NonNull String firstName, @NonNull String lastName, @NonNull Integer age, @NonNull Group group, UUID studentId);

}