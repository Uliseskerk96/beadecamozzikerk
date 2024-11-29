package com.desi.beadecamozzikerk.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "camiones")
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementar ID
	@Column(name = "camion_id")
	private Long id;

	@Column(name = "patente", unique = true, nullable = false)
	private String patente;

	@Column(nullable = false)
	private String ciudadActual;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false, length = 4)
	private int modelo; // Año de fabricación

	public Camion(String patente, String ciudadActual, String marca, int modelo) {
		super();
		this.patente = patente;
		this.ciudadActual = ciudadActual;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Camion() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getCiudadActual() {
		return ciudadActual;
	}

	public void setCiudadActual(String ciudadActual) {
		this.ciudadActual = ciudadActual;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

}
