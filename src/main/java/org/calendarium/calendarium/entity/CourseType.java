package org.calendarium.calendarium.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "course_types")
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_type_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseType that = (CourseType) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CourseType{" +
                " id: " + id +
                ", typeDescription: '" + name + '\'' +
                '}';
    }
}