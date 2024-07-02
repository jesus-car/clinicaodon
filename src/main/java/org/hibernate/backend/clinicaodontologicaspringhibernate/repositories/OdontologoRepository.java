package org.hibernate.backend.clinicaodontologicaspringhibernate.repositories;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    Optional<Odontologo> findByMatricula(String email);
    boolean existsByNombre(String nombre);
}
