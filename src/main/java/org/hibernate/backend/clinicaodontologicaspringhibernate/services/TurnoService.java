package org.hibernate.backend.clinicaodontologicaspringhibernate.services;

import org.hibernate.backend.clinicaodontologicaspringhibernate.dto.TurnoDTO;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Odontologo;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Paciente;
import org.hibernate.backend.clinicaodontologicaspringhibernate.entities.Turno;
import org.hibernate.backend.clinicaodontologicaspringhibernate.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    public Turno registrarTurno(Turno turno){
        Optional<Paciente> paciente = pacienteService.findById(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(turno.getOdontologo().getId());

        if(paciente.isPresent() && odontologo.isPresent()){
            turno.setPaciente(paciente.get());
            turno.setOdontologo(odontologo.get());
            return turnoRepository.save(turno);
        }else{
            throw new RuntimeException("No se pudo registrar el turno");
        }
    }

    public Optional<Turno> buscarPorId(Long id){
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isEmpty()){
            throw new RuntimeException("Turno no encontrado");
        }
        return turno;
    }

    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }

    public void actualizarTurno(Turno turno){
        turnoRepository.save(turno);
    }

    public List<Turno> listarTodos(){
        return turnoRepository.findAll();
    }

    public TurnoDTO turnoAturnoDTO(Turno turno){
        TurnoDTO turnoDTO= new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setPacienteId(turno.getPaciente().getId());
        turnoDTO.setOdontologoId(turno.getOdontologo().getId());

        return turnoDTO;
    }

    public Turno turnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno= new Turno();
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();
        odontologo.setId(turnoDTO.getOdontologoId());
        paciente.setId(turnoDTO.getPacienteId());
        turno.setFecha(turnoDTO.getFecha());
        turno.setId(turnoDTO.getId());
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        return turno;
    }
}
