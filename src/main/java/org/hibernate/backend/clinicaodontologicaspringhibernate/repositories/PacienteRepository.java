package org.hibernate.backend.clinicaodontologicaspringhibernate.repositories;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByEmail(String email);
    boolean existsByNombre(String nombre);
    boolean existsByEmail(String email);
    boolean existsByCedula(Integer cedula);

}
