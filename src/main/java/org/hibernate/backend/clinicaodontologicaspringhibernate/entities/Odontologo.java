package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "odontologos")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;
    private String nombre;
    private String apellido;

}
