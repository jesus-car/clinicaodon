package org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Logs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogsDatesDB {

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
