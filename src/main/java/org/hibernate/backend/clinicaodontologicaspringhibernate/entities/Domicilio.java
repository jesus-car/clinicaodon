package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
