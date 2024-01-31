package com.helio.examen2.model;

import java.time.LocalDate;


public class UsuarioPojo {
	private long id;
	private String clave;
	private String tipo;
	private String nombre;
	private String username;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String password;
	private String tipoUsuario;
	private LocalDate fechaInicioSesion;
	private LocalDate fechaFinSesion;
	private String tiempoEnLinea;
	private boolean estatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public LocalDate getFechaInicioSesion() {
		return fechaInicioSesion;
	}

	public void setFechaInicioSesion(LocalDate fechaInicioSesion) {
		this.fechaInicioSesion = fechaInicioSesion;
	}

	public LocalDate getFechaFinSesion() {
		return fechaFinSesion;
	}

	public void setFechaFinSesion(LocalDate fechaFinSesion) {
		this.fechaFinSesion = fechaFinSesion;
	}

	public String getTiempoEnLinea() {
		return tiempoEnLinea;
	}

	public void setTiempoEnLinea(String tiempoEnLinea) {
		this.tiempoEnLinea = tiempoEnLinea;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public UsuarioPojo(long id, String clave, String tipo, String nombre, String username, String apellidoPaterno,
			String apellidoMaterno, String password, String tipoUsuario, LocalDate fechaInicioSesion,
			LocalDate fechaFinSesion, String tiempoEnLinea, boolean estatus) {
		super();
		this.id = id;
		this.clave = clave;
		this.tipo = tipo;
		this.nombre = nombre;
		this.username = username;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.fechaInicioSesion = fechaInicioSesion;
		this.fechaFinSesion = fechaFinSesion;
		this.tiempoEnLinea = tiempoEnLinea;
		this.estatus = estatus;
	}

	public UsuarioPojo() {
		// TODO Auto-generated constructor stub
	}

}
