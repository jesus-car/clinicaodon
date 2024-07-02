package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties({"roles", "hibernateLazyInitializer", "handler"})
    private Set<User> users;

    public Role() {
        this.users = new HashSet<>();
    }
}
