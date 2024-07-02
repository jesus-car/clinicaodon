package org.hibernate.backend.clinicaodontologicaspringhibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.PacienteService;
import org.hibernate.backend.clinicaodontologicaspringhibernate.validation.ExistByName;
import org.hibernate.backend.clinicaodontologicaspringhibernate.validation.ExistsByCedula;
import org.hibernate.backend.clinicaodontologicaspringhibernate.validation.ExistsByEmail;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 50)
    @ExistByName(entityService = PacienteService.class)
    private String nombre;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String apellido;

    @NotNull
    @Column(unique = true, nullable = false)
    @ExistsByCedula
    private Integer cedula;

    @NotNull
    private LocalDate fechaIngreso;

    @NotEmpty
    @Column(unique = true, nullable = false)
    @ExistsByEmail
    private String email;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @Column(name = "create_at")
    private LocalDateTime fechaAlta;

    @Column(name = "updated_at")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    public void prePersist(){
        fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        fechaActualizacion = LocalDateTime.now();
    }
}
