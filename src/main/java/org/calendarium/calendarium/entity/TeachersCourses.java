package org.calendarium.calendarium.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "teachers_courses")
public class TeachersCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "teacher_courses_id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachersCourses that = (TeachersCourses) o;
        return Objects.equals(id, that.id)
                && Objects.equals(course, that.course)
                && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TeachersCourses{" +
                "id: " + id +
                ", course: " + course +
                ", teacher: " + teacher +
                '}';
    }
}