package org.hibernate.backend.clinicaodontologicaspringhibernate.controllers;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Turno;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarTurno(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminado con exito");
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }
}
