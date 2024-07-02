package org.hibernate.backend.clinicaodontologicaspringhibernate.controllers;

import jakarta.validation.Valid;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Paciente;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPaciente(@Valid @RequestBody Paciente paciente, BindingResult result) {
        if (result.hasErrors()) return validation(result);
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.actualizarPaciente(id, paciente));
    }

    @GetMapping("/buscar/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(pacienteService.buscarPorEmail(email));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.eliminarPorId(id));
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
}
