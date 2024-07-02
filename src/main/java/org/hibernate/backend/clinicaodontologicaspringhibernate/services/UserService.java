package org.hibernate.backend.clinicaodontologicaspringhibernate.services;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Role;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.User;
import org.hibernate.backend.clinicaodontologicaspringhibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User guardarUsuario(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName("ROLE_USER"));
        user.setRoles(roles);

        if (user.isAdmin())
            roles.add(roleService.findByName("ROLE_ADMIN"));

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

}
