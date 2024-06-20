package org.hibernate.backend.clinicaodontologicaspringhibernate.services;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Paciente;
import org.hibernate.backend.clinicaodontologicaspringhibernate.exceptions.PacienteEqualEmailException;
import org.hibernate.backend.clinicaodontologicaspringhibernate.exceptions.PacienteNotFoundException;
import org.hibernate.backend.clinicaodontologicaspringhibernate.repositories.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    // guardar paciente, actualizar paciente, buscar por id, buscar por email, buscar todos, borrar por id
    public Paciente savePaciente(Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findByEmail(paciente.getEmail());
        if (pacienteOptional.isPresent()) {
            throw new PacienteEqualEmailException("El email ya se encuentra registrado", paciente.getEmail());
        }
        return pacienteRepository.save(paciente);
    }

    @Transactional(readOnly = true)
    public Iterable<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Paciente> findById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            throw new PacienteNotFoundException("Paciente no encontrado", id);
        }
        return paciente;
    }

    @Transactional(readOnly = true)
    public Optional<Paciente> findByEmail(String email) {
        Optional<Paciente> paciente = pacienteRepository.findByEmail(email);
        if (paciente.isEmpty()) {
            throw new PacienteNotFoundException("Paciente no encontrado", 0L);
        }
        return pacienteRepository.findByEmail(email);
    }

    @Transactional
    public Paciente actualizarPaciente(Long id, Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isEmpty()) {
            throw new PacienteNotFoundException("Paciente no encontrado", id);
        }
        if(!paciente.getEmail().equals(pacienteOptional.get().getEmail())){
            Optional<Paciente> pacienteOptionalEmail = pacienteRepository.findByEmail(paciente.getEmail());
            if (pacienteOptionalEmail.isPresent()) {
                throw new PacienteEqualEmailException("El email ya se encuentra registrado", paciente.getEmail());
            }
        }
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    @Transactional
    public Optional<Paciente> deleteById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            throw new PacienteNotFoundException("Paciente no encontrado", id);
        }
        pacienteRepository.deleteById(id);
        return paciente;
    }
}
