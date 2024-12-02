package com.desi.beadecamozzikerk.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubicacion_id")
    private Long id;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "estado_clima", nullable = false)
    private String estadoClima;
    
    @Column(name ="cod_Postal", nullable = false)
    private Integer codPostal;
    
    @Column(name ="patente", nullable = false)
    private String patente;

    public Ubicacion() {
    }

    public Ubicacion(String ciudad, String estadoClima, Integer codPostal, String patente) {
        this.ciudad = ciudad;
        this.estadoClima = estadoClima;
        this.codPostal = codPostal;
        this.patente = patente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadoClima() {
        return estadoClima;
    }
    
   

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }
    
    public Integer getCodPostal() {
        return codPostal;
    }
    
    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }
    
    public String getPatente( ) {
    	return patente;
    }
    
    public void setPatente(String patente) {
    	this.patente = patente;
    }
}
