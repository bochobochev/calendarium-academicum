package org.calendarium.calendarium.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "students")
@Builder
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(nullable = false, name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student")
    private Set<CoursesStudents> coursesEnrolments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId)
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(age, student.age)
                && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, age, group);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "studentId : " + studentId + ", " +
                "firstName : " + firstName + ", " +
                "lastName : " + lastName + ", " +
                "age : " + age + ", " +
                "group : " + group + "}";
    }
}