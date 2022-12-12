package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    List<Paciente> findByNombre (String nombre);
}
