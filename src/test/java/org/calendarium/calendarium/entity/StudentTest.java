package org.calendarium.calendarium.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

class StudentTest {
    @Mock
    UUID studentId;
    @Mock
    Group group;
    @InjectMocks
    Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEquals() {
        Student student1 = new Student(new UUID(0L, 0L), "firstName", "lastName", 0, new Group());
        boolean result = student1.equals(student1);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = student.hashCode();
        Assertions.assertEquals(-1973979810, result);
    }

    @Test
    void testToString() {
        String result = student.toString();
        Assertions.assertEquals("Student{studentId : studentId, firstName : null, lastName : null, age : null, group : group}", result);
    }
}