package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "turnos")
public class Turno {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fecha;

        @OneToOne(cascade = CascadeType.ALL)
        private Paciente paciente;

        @OneToOne(cascade = CascadeType.ALL)
        private Odontologo odontologo;
}
