package org.hibernate.backend.clinicaodontologicaspringhibernate.controllers;

import jakarta.validation.Valid;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Paciente;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // guardar paciente, actualizar paciente, buscar por id, buscar por email, buscar todos, borrar por id

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPaciente(@Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.savePaciente(paciente));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.actualizarPaciente(id, paciente));
    }

    @GetMapping("/buscar/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(pacienteService.findByEmail(email));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.deleteById(id));
    }
}
