package org.hibernate.backend.clinicaodontologicaspringhibernate.services;

import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Odontologo;
import org.hibernate.backend.clinicaodontologicaspringhibernate.repositories.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Transactional
    public Odontologo registrarOdontologo(Odontologo odontologo){
        Optional<Odontologo> odontologoOptional = odontologoRepository.findByMatricula(odontologo.getMatricula());
        if(odontologoOptional.isPresent()){
            throw new RuntimeException("Ya existe un odontologo con esa matricula");
        }
        return odontologoRepository.save(odontologo);
    }

    @Transactional(readOnly = true)
    public Optional<Odontologo> buscarPorId(Long id){
        return odontologoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Odontologo> buscarPorMatricula(String matricula){
        return odontologoRepository.findByMatricula(matricula);
    }

    @Transactional
    public Optional<Odontologo> eliminarOdontologo(Long id){
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        if(odontologoOptional.isEmpty()){
            throw new RuntimeException("No existe un odontologo con ese id");
        }
        odontologoRepository.deleteById(id);
        return odontologoOptional;
    }

    @Transactional
    public Odontologo actualizarOdontologo(Long id, Odontologo odontologo){
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        if(odontologoOptional.isEmpty()){
            throw new RuntimeException("No existe un odontologo con ese id");
        }
        if(!odontologo.getMatricula().equals(odontologoOptional.get().getMatricula())){
            Optional<Odontologo> odontologoMatriculaOptional = odontologoRepository.findByMatricula(odontologo.getMatricula());
            if(odontologoMatriculaOptional.isPresent()){
                throw new RuntimeException("Ya existe un odontologo con esa matricula");
            }
        }
        odontologo.setId(id);
        return odontologoRepository.save(odontologo);
    }

    @Transactional(readOnly = true)
    public Iterable<Odontologo> listarTodos() {
        return odontologoRepository.findAll();
    }

}
