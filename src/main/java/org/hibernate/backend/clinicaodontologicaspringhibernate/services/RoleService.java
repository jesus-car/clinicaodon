package org.hibernate.backend.clinicaodontologicaspringhibernate.services;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Role;
import org.hibernate.backend.clinicaodontologicaspringhibernate.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Role findByName(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if(role.isEmpty()){
            throw new RuntimeException("Role not found");
        }
        return role.get();
    }
}
