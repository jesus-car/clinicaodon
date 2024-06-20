package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "turnos")
public class Turno {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDate fecha;

        @ManyToOne
        @JoinColumn(name = "paciente_id",referencedColumnName = "id")
        private Paciente paciente;

        @ManyToOne
        @JoinColumn(name = "odontologo_id", referencedColumnName = "id")
        private Odontologo odontologo;
}
