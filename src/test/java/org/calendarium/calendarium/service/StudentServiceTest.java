package org.calendarium.calendarium.service;

import org.calendarium.calendarium.core.assemblers.StudentAssembler;
import org.calendarium.calendarium.entity.CoursesStudents;
import org.calendarium.calendarium.entity.Group;
import org.calendarium.calendarium.entity.Student;
import org.calendarium.calendarium.repo.CoursesStudentsRepository;
import org.calendarium.calendarium.repo.StudentRepository;
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

class StudentServiceTest {
    public static final Group GROUP = new Group(new UUID(0L, 0L), Integer.valueOf(0), "groupName");
    public static final Student STUDENT = new Student(new UUID(0L, 0L), "firstName", "lastName",
            Integer.valueOf(0),GROUP);
    @Mock
    StudentRepository studentRepository;
    @Mock
    CoursesStudentsRepository coursesStudentsRepository;
    @Mock
    GroupService groupService;
    @Mock
    StudentAssembler studentAssembler;
    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        when(studentRepository.save(any(Student.class))).thenReturn(STUDENT);
        when(coursesStudentsRepository.save(any(CoursesStudents.class))).thenReturn(new CoursesStudents());

        Student result = studentService.save(STUDENT);

        Assertions.assertEquals(STUDENT, result);
    }

    @Test
    void testUpdate() {
        when(studentRepository.update(anyString(), anyString(), anyInt(), any(Group.class), any(UUID.class))).thenReturn(0);
        when(studentRepository.findById(any(UUID.class))).thenReturn(Optional.of(STUDENT));
        when(coursesStudentsRepository.findById(any(UUID.class))).thenReturn(null);

        Optional<Student> result = studentService.update(new UUID(0L, 0L), STUDENT);

        Assertions.assertEquals(Optional.of(STUDENT), result);
    }

    @Test
    void testDelete() {
        when(studentRepository.findById(any(UUID.class))).thenReturn(Optional.of(STUDENT));
        when(coursesStudentsRepository.findById(any(UUID.class))).thenReturn(null);

        Optional<Student> result = studentService.delete(new UUID(0L, 0L));

        verify(studentRepository).delete(any(Student.class));
//        verify(coursesStudentsRepository).delete(any(CoursesStudents.class));
        Assertions.assertEquals(Optional.of(STUDENT), result);
    }

    @Test
    void testCount() {
        when(studentRepository.count()).thenReturn(0L);
        when(coursesStudentsRepository.count()).thenReturn(0L);

        long result = studentService.count();

        Assertions.assertEquals(0L, result);
    }

    @Test
    void testFindById() {
        when(studentRepository.findById(any(UUID.class))).thenReturn(null);
        when(coursesStudentsRepository.findById(any(UUID.class))).thenReturn(null);

        Optional<Student> result = studentService.findById(new UUID(0L, 0L));

        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindByGroupNumber() {
        List<Student> expectedListOfStudents = List.of(STUDENT);
        when(studentRepository.findByGroup(any(Group.class))).thenReturn(expectedListOfStudents);
        when(groupService.getGroupByGroupNumber(anyInt())).thenReturn(Optional.of(GROUP));

        Optional<List<Student>> result = studentService.findByGroupNumber(Integer.valueOf(0));

        Assertions.assertEquals(Optional.of(expectedListOfStudents), result);
    }

    @Test
    void testGetStudentsOlderThanAgeInCourse() {
        when(coursesStudentsRepository.findByCourse_IdAndStudent_AgeGreaterThan(any(UUID.class),
                anyInt())).thenReturn(List.of(new CoursesStudents()));

        Optional<List<CoursesStudents>> result = studentService.getStudentsOlderThanAgeInCourse(
                Integer.valueOf(0), new UUID(0L, 0L));

        Assertions.assertEquals(Optional.of(List.of(new CoursesStudents())), result);
    }
}
