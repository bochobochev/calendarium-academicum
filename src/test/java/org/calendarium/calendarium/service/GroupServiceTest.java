package org.calendarium.calendarium.service;

import org.calendarium.calendarium.entity.Group;
import org.calendarium.calendarium.repo.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

class GroupServiceTest {
    @Mock
    GroupRepository groupRepository;
    @InjectMocks
    GroupService groupService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetGroupByGroupNumber() {
        Group expectedGrpup = new Group(new UUID(0L, 0L), Integer.valueOf(0), "groupName");
        when(groupRepository.findByGroupNumber(anyInt())).thenReturn(List.of(expectedGrpup));

        Optional<Group> result = groupService.getGroupByGroupNumber(Integer.valueOf(0));
        Assertions.assertEquals(Optional.of(expectedGrpup), result);
    }
}
