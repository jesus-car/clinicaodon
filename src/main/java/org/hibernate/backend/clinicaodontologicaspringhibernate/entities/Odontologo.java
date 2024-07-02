package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.OdontologoService;
import org.hibernate.backend.clinicaodontologicaspringhibernate.validation.ExistByName;

@Entity
@Data
@Table(name = "odontologos")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    @NotBlank
    @ExistByName(entityService = OdontologoService.class)
    private String nombre;

    @NotBlank
    private String apellido;

}
