package org.calendarium.calendarium.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "horarium", nullable = false)
    private Integer horarium;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "course_type_id")
    private CourseType courseType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id)
                && Objects.equals(name, course.name)
                && Objects.equals(description, course.description)
                && Objects.equals(horarium, course.horarium)
                && Objects.equals(courseType, course.courseType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", description: '" + description + '\'' +
                ", horarium: " + horarium +
                ", courseType: " + courseType +
                '}';
    }
}