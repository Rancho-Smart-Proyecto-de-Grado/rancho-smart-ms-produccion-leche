package com.rancho_smart.ms_produccion_leche.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCCION_LECHE")
public class ProduccionLeche {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduccionLeche;

    @Column(name = "ID_ANIMAL")
    private Long idAnimal;

    @Column(name = "CANTIDAD_REGISTRADA")
    private Float cantidadRegistrada;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @Column(name = "ID_LOTE")
    private Long idLote;

    @Column(name = "ID_FINCA")
    private Long idFinca;

    public ProduccionLeche() {
    }

    public ProduccionLeche(Long idAnimal, Float cantidadRegistrada, LocalDateTime fecha, Long idLote, Long idFinca) {
        this.idAnimal = idAnimal;
        this.cantidadRegistrada = cantidadRegistrada;
        this.fecha = fecha;
        this.idLote = idLote;
        this.idFinca = idFinca;
    }

    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    public Long getIdProduccionLeche() {
        return idProduccionLeche;
    }

    public void setIdProduccionLeche(Long idProduccionLeche) {
        this.idProduccionLeche = idProduccionLeche;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Float getCantidadRegistrada() {
        return cantidadRegistrada;
    }

    public void setCantidadRegistrada(Float cantidadRegistrada) {
        this.cantidadRegistrada = cantidadRegistrada;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
