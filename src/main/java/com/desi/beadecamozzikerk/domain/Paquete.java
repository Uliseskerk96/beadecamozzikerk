package com.desi.beadecamozzikerk.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paquetes")
public class Paquete {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-incrementar ID
	@Column(name = "id")
    private Long id;
	
	@Column(name = "nombre", nullable = false)
    private String nombre;
	
	@Column(name = "descripcion",nullable = false)
    private String descripcion;
	
	@Column(name = "destino",nullable = false)
    private String destino;
	
	@Column(name = "peso",nullable = false)
    private double peso;
	
	@Column(name = "estado",nullable = false)
    private String estado;

    // Constructor
    public Paquete() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
 
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
