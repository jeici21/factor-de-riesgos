package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    @Max(100)
    @Positive
    private Float porcentajeAzucar;
    @Column(nullable = false)
    @Max(100)
    @Positive
    private Float porcentajeGrasa;
    @Column(nullable = false)
    @Max(100)
    @Positive
    private Float porcentajeOxigeno;
/*     @Column(nullable = false, insertable = false, updatable = false)
    private String riesgo; */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public @Max(100) @Positive Float getPorcentajeAzucar() {
        return porcentajeAzucar;
    }

    public void setPorcentajeAzucar(@Max(100) @Positive Float porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public @Max(100) @Positive Float getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(@Max(100) @Positive Float porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public @Max(100) @Positive Float getPorcentajeOxigeno() {
        return porcentajeOxigeno;
    }

    public void setPorcentajeOxigeno(@Max(100) @Positive Float porcentajeOxigeno) {
        this.porcentajeOxigeno = porcentajeOxigeno;
    }

/*     public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    } */
}
