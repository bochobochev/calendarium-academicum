package org.calendarium.calendarium.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "groups")
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "group_id", nullable = false)
    private UUID groupId;

    @Column(name = "group_number", nullable = false)
    private Integer groupNumber;

    @Column(name = "name")
    private String groupName;


    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Group group = (Group) o;
        return groupId != null && Objects.equals(groupId, group.groupId);
    }
}