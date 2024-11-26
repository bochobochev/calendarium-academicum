package org.calendarium.calendarium.service;

import org.calendarium.calendarium.entity.Teacher;
import org.calendarium.calendarium.repo.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

class TeacherServiceTest {
    @Mock
    TeacherRepository teacherRepository;
    @InjectMocks
    TeacherService teacherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        when(teacherRepository.save(any(Teacher.class))).thenReturn(Teacher.builder().build());

        Teacher result = teacherService.save(Teacher.builder().build());
        Assertions.assertEquals(Teacher.builder().build(), result);
    }

    @Test
    void testUpdate() {
        when(teacherRepository.update(anyString(), anyString(), anyInt(), any(UUID.class))).thenReturn(0);
        when(teacherRepository.findById(any(UUID.class))).thenReturn(null);

        Optional<Teacher> result = teacherService.update(new UUID(0L, 0L), Teacher.builder().build());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCount() {
        when(teacherRepository.count()).thenReturn(0L);

        long result = teacherService.count();
        Assertions.assertEquals(0L, result);
    }

    @Test
    void testFindById() {
        when(teacherRepository.findById(any(UUID.class))).thenReturn(null);

        Optional<Teacher> result = teacherService.findById(new UUID(0L, 0L));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDelete() {
        Teacher teacher = Teacher.builder().teachersId(new UUID(0L, 0L)).age(0).firstName("firstName").lastName("lastName").build();
        when(teacherRepository.findById(any(UUID.class))).thenReturn(Optional.of(teacher));

        Optional<Teacher> result = teacherService.delete(new UUID(0L, 0L));
        verify(teacherRepository).delete(any(Teacher.class));
        Assertions.assertEquals(Optional.of(teacher), result);
    }
}
