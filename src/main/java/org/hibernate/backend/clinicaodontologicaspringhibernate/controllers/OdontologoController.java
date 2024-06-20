package org.hibernate.backend.clinicaodontologicaspringhibernate.controllers;

import jakarta.validation.Valid;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Odontologo;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarOdontologo(@Valid @RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarOdontologo(@PathVariable Long id, @Valid @RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizarOdontologo(id, odontologo));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(odontologoService.buscarPorId(id));
    }

    @GetMapping("/buscar/matricula/{matricula}")
    public ResponseEntity<?> buscarPorMatricula(@PathVariable String matricula){
        return ResponseEntity.ok().body(odontologoService.buscarPorMatricula(matricula));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<?> buscarTodos(){
        return ResponseEntity.ok().body(odontologoService.listarTodos());
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        return ResponseEntity.ok().body(odontologoService.eliminarOdontologo(id));
    }
}
