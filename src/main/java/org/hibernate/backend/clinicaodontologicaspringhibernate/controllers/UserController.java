package org.hibernate.backend.clinicaodontologicaspringhibernate.controllers;

import jakarta.validation.Valid;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.User;
import org.hibernate.backend.clinicaodontologicaspringhibernate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser (@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        user.setAdmin(false);
        return ResponseEntity.ok(userService.guardarUsuario(user));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }
}
