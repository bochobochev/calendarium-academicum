package org.calendarium.calendarium.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "courses_students")
public class CoursesStudents {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "courses_student_id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesStudents that = (CoursesStudents) o;
        return Objects.equals(id, that.id)
                && Objects.equals(course, that.course)
                && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CoursesStudents{" +
                " id: " + id +
                ", course: " + course +
                ", student: " + student +
                '}';
    }
}