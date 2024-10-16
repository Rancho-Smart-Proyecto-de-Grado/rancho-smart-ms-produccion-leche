package  com.rancho_smart.ms_produccion_leche.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Leche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idLote;

    @Column(nullable = false)
    private Long idAnimal;

    @Column(nullable = false)
    private LocalDate fechaExtraccion;

    @Column(nullable = false)
    private double cantidad; // Cantidad de leche extraída en litros

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public LocalDate getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(LocalDate fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }


    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    //Constructores

    public Leche() {
    }

    public Leche(Long idLote, Long idAnimal, LocalDate fechaExtraccion, double cantidad) {
        this.idLote = idLote;
        this.idAnimal = idAnimal;
        this.fechaExtraccion = fechaExtraccion;
        this.cantidad = cantidad;
    }
    

}
