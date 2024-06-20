package org.hibernate.backend.clinicaodontologicaspringhibernate.repositories;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
