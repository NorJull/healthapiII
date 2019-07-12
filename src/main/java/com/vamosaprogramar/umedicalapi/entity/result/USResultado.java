package com.vamosaprogramar.umedicalapi.entity.result;

public class USResultado {

	private String tipoDocumento;
	
	private String documento;
	
	private String prestador;
	
	private String tipoUsuario;
	
	private String primerApellido;
	
	private String segundoApellido;
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String edad; 
	
	private String unidadMedidaEdad;
	
	private String sexo;
	
	private String departamento;
	
	private String municipio;

	private String zona;

	public USResultado() {
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getUnidadMedidaEdad() {
		return unidadMedidaEdad;
	}

	public void setUnidadMedidaEdad(String unidadMedidaEdad) {
		this.unidadMedidaEdad = unidadMedidaEdad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public String[] getStringArray() {
		String[] datos = {tipoDocumento, documento, prestador, tipoUsuario, primerApellido, 
				segundoApellido, primerNombre, segundoNombre, edad, unidadMedidaEdad, sexo, departamento, municipio, zona};
		return datos;
	}
	
	
}
