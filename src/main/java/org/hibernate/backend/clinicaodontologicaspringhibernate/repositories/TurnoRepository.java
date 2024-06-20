package org.hibernate.backend.clinicaodontologicaspringhibernate.repositories;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
