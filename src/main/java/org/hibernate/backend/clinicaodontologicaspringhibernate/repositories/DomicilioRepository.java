package org.hibernate.backend.clinicaodontologicaspringhibernate.repositories;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
