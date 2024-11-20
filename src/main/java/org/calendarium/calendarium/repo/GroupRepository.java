package org.calendarium.calendarium.repo;

import org.calendarium.calendarium.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    List<Group> findByGroupNumber(Integer groupNumber);
}