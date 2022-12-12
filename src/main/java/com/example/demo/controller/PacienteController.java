package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Paciente;
import com.example.demo.repository.PacienteRepository;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public Iterable<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/nombre/{nombrePaciente}")
    public List<Paciente> findByNombre(@PathVariable String nombrePaciente) {
        return pacienteRepository.findByNombre(nombrePaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            return ResponseEntity.ok(pacienteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Paciente> o = pacienteRepository.findById(id);
        if (o.isPresent()) {
            pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente(@RequestBody Paciente paciente, @PathVariable Long id) {
        Optional<Paciente> o = pacienteRepository.findById(id);
        if (o.isPresent()) {
            Paciente pacienteDb = o.get();
            pacienteDb.setNombre(paciente.getNombre());
            pacienteDb.setApellido(paciente.getApellido());
            pacienteDb.setPorcentajeAzucar(paciente.getPorcentajeAzucar());
            pacienteDb.setPorcentajeGrasa(paciente.getPorcentajeGrasa());
            pacienteDb.setPorcentajeOxigeno(paciente.getPorcentajeOxigeno());
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(pacienteDb));
        }
        return ResponseEntity.notFound().build();
    }
}
