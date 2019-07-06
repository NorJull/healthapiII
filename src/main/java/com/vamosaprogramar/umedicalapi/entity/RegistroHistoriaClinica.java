package com.vamosaprogramar.umedicalapi.entity;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

@Entity
@Table(name = "registro_historia_clinica")
public class RegistroHistoriaClinica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "paciente_id")
	private int pacienteId;
	
	@Column(name="fecha_entrada")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fechaEntrada;
	
	@Column(name = "hora_entrada")
	@Convert(converter = LocalTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  horaEntrada;

	@Column(name="fecha_salida")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fechaSalida;
	
	@Column(name = "hora_salida")
	@Convert(converter = LocalTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  horaSalida;
	
	@Column(name = "departamento")
	private String departamento;
	
	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "tipo_usuario")
	private String tipoUsuario;
	
	@Column(name = "primer_apellido")
	private String primerApellido;
	
	@Column(name = "segundo_apellido")
	private String segundoApellido;
	
	@Column(name = "primer_nombre")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "unidad_medida_edad")
	private int unidadMedidaEdad;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "zona")
	private String zona;
		
	@Column(name = "telefono_acompanante")
	private String telefonoAcompanante;
	
	@Column(name = "nombre_acompanante")
	private String nombreAcompanante;
	
	@Column(name = "finalidad")
	private String finalidad;
	
	@Column(name = "tipo_diagnostico_principal")
	private String tipoDiagnosticoPrincipal;
	
	@Column(name = "causa_externa")
	private String causaExterna;
	
	@Column(name = "motivo_consulta")
	private String motivoConsulta;
	
	@Column(name = "revision_por_sistemas")
	private String revisionPorSistemas;
	
	@Column(name = "antecedentes_personales")
	private String antecedentesPersonales;
	
	@Column(name = "antecedentes_alergicos")
	private String antecedentesAlergicos;
	
	@Column(name = "antecedentes_familiares")
	private String atecedentesFamiliares;
	
	@Column(name = "antecedentes_quirurgicos")
	private String antecedentesQuirurgicos;
	
	@Column(name = "antecedentes_ginecoobstetricos")
	private String antecedentesGinecoobctetricos;
	
	@Column(name = "frecuencia_cardiaca")
	private int frecuenciaCardiaca;
	
	@Column(name = "frecuencia_respiratoria")
	private int frecuenciaRespiratoria;
	
	@Column(name = "tension_sistolica")
	private String tensionSistolica;
	
	@Column(name = "tension_diastolica")
	private String tensionDiastolica;
	
	@Column(name = "temperatura_corporal")
	private int temperaturaCorporal;
	
	@Column(name = "talla")
	private int talla;
	
	@Column(name = "peso")
	private int peso;
	
	@Column(name = "cintura")
	private int cintura;
	
	@Column(name = "imc")
	private int imc;

	@Column(name = "apariencia_llegada")
	private String aparienciaLlegada;

	@Column(name = "craneo_cara_cuello")
	private String craneoCaraCuello;

	@Column(name = "torax")
	private String torax;
	
	@Column(name = "abdomen")
	private String abdomen;

	@Column(name = "piel_faneras")
	private String pielFaneras;
	
	@Column(name = "genito_urinario")
	private String genitoUrinario;

	@Column(name = "extremidades")
	private String extremidades;

	@Column(name = "sistema_nervioso_central")
	private String sistemaNerviosoCentral;

	@Column(name = "sistema_afectado")
	private String sistemaAfectado;

	@Column(name = "plan")
	private String plan;
	
	@Column(name = "recomendaciones")
	private String recomendaciones;

	@Column(name = "observaciones")
	private String observaciones;

	@Column(name = "codigo_diagnostico_principal")
	private String codigoDiagnosticoPrincipal;
	
	@Column(name = "codigo_diagnostico_relacionado_1")
	private String codigoDiagnosticoRelacionado1;
	
	@Column(name = "codigo_diagnostico_relacionado_2")
	private String codigoDiagnosticoRelacionado2;
	
	@Column(name = "codigo_diagnostico_relacionado_3")
	private String codigoDiagnosticoRelacionado3;
	
	@Column(name = "procedimiento_consulta")
	private String procedimientoConsulta;
	
	@Column(name = "cup_procedimiento_consulta")
	private String cupProcedimientoConsulta;
	
	@Column(name = "contrato_id")
	private Integer contratoId;
	
	@OneToMany(mappedBy = "registroHistoriaClinica", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<Procedimiento> procedimientos;
	
	@OneToMany(mappedBy = "registroHistoriaClinica", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<ProcedimientoOrdenado> procedimientosOrdenados;

	@OneToMany(mappedBy = "registroHistoriaClinica", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<Medicamento> medicamentos;
	
	@OneToMany(mappedBy = "registroHistoriaClinica", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<Remision> remisiones;
	
	public RegistroHistoriaClinica() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getUnidadMedidaEdad() {
		return unidadMedidaEdad;
	}

	public void setUnidadMedidaEdad(int unidadMedidaEdad) {
		this.unidadMedidaEdad = unidadMedidaEdad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getTelefonoAcompanante() {
		return telefonoAcompanante;
	}

	public void setTelefonoAcompanante(String telefonoAcompanante) {
		this.telefonoAcompanante = telefonoAcompanante;
	}

	public String getNombreAcompanante() {
		return nombreAcompanante;
	}

	public void setNombreAcompanante(String nombreAcompanante) {
		this.nombreAcompanante = nombreAcompanante;
	}

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public String getTipoDiagnosticoPrincipal() {
		return tipoDiagnosticoPrincipal;
	}

	public void setTipoDiagnosticoPrincipal(String tipoDiagnosticoPrincipal) {
		this.tipoDiagnosticoPrincipal = tipoDiagnosticoPrincipal;
	}

	public String getCausaExterna() {
		return causaExterna;
	}

	public void setCausaExterna(String causaExterna) {
		this.causaExterna = causaExterna;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getRevisionPorSistemas() {
		return revisionPorSistemas;
	}

	public void setRevisionPorSistemas(String revisionPorSistemas) {
		this.revisionPorSistemas = revisionPorSistemas;
	}

	public String getAntecedentesPersonales() {
		return antecedentesPersonales;
	}

	public void setAntecedentesPersonales(String antecedentesPersonales) {
		this.antecedentesPersonales = antecedentesPersonales;
	}

	public String getAntecedentesAlergicos() {
		return antecedentesAlergicos;
	}

	public void setAntecedentesAlergicos(String antecedentesAlergicos) {
		this.antecedentesAlergicos = antecedentesAlergicos;
	}

	public String getAtecedentesFamiliares() {
		return atecedentesFamiliares;
	}

	public void setAtecedentesFamiliares(String atecedentesFamiliares) {
		this.atecedentesFamiliares = atecedentesFamiliares;
	}

	public String getAntecedentesQuirurgicos() {
		return antecedentesQuirurgicos;
	}

	public void setAntecedentesQuirurgicos(String antecedentesQuirurgicos) {
		this.antecedentesQuirurgicos = antecedentesQuirurgicos;
	}

	public String getAntecedentesGinecoobctetricos() {
		return antecedentesGinecoobctetricos;
	}

	public void setAntecedentesGinecoobctetricos(String antecedentesGinecoobctetricos) {
		this.antecedentesGinecoobctetricos = antecedentesGinecoobctetricos;
	}

	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public int getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public String getTensionSistolica() {
		return tensionSistolica;
	}

	public void setTensionSistolica(String tensionSistolica) {
		this.tensionSistolica = tensionSistolica;
	}

	public String getTensionDiastolica() {
		return tensionDiastolica;
	}

	public void setTensionDiastolica(String tensionDiastolica) {
		this.tensionDiastolica = tensionDiastolica;
	}

	public int getTemperaturaCorporal() {
		return temperaturaCorporal;
	}

	public void setTemperaturaCorporal(int temperaturaCorporal) {
		this.temperaturaCorporal = temperaturaCorporal;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getCintura() {
		return cintura;
	}

	public void setCintura(int cintura) {
		this.cintura = cintura;
	}

	public int getImc() {
		return imc;
	}

	public void setImc(int imc) {
		this.imc = imc;
	}

	public String getAparienciaLlegada() {
		return aparienciaLlegada;
	}

	public void setAparienciaLlegada(String aparienciaLlegada) {
		this.aparienciaLlegada = aparienciaLlegada;
	}

	public String getCraneoCaraCuello() {
		return craneoCaraCuello;
	}

	public void setCraneoCaraCuello(String craneoCaraCuello) {
		this.craneoCaraCuello = craneoCaraCuello;
	}

	public String getTorax() {
		return torax;
	}

	public void setTorax(String torax) {
		this.torax = torax;
	}

	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	public String getPielFaneras() {
		return pielFaneras;
	}

	public void setPielFaneras(String pielFaneras) {
		this.pielFaneras = pielFaneras;
	}

	public String getGenitoUrinario() {
		return genitoUrinario;
	}

	public void setGenitoUrinario(String genitoUrinario) {
		this.genitoUrinario = genitoUrinario;
	}

	public String getExtremidades() {
		return extremidades;
	}

	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}

	public String getSistemaNerviosoCentral() {
		return sistemaNerviosoCentral;
	}

	public void setSistemaNerviosoCentral(String sistemaNerviosoCentral) {
		this.sistemaNerviosoCentral = sistemaNerviosoCentral;
	}

	public String getSistemaAfectado() {
		return sistemaAfectado;
	}

	public void setSistemaAfectado(String sistemaAfectado) {
		this.sistemaAfectado = sistemaAfectado;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCodigoDiagnosticoPrincipal() {
		return codigoDiagnosticoPrincipal;
	}

	public void setCodigoDiagnosticoPrincipal(String codigoDiagnosticoPrincipal) {
		this.codigoDiagnosticoPrincipal = codigoDiagnosticoPrincipal;
	}

	public String getCodigoDiagnosticoRelacionado1() {
		return codigoDiagnosticoRelacionado1;
	}

	public void setCodigoDiagnosticoRelacionado1(String codigoDiagnosticoRelacionado1) {
		this.codigoDiagnosticoRelacionado1 = codigoDiagnosticoRelacionado1;
	}

	public String getCodigoDiagnosticoRelacionado2() {
		return codigoDiagnosticoRelacionado2;
	}

	public void setCodigoDiagnosticoRelacionado2(String codigoDiagnosticoRelacionado2) {
		this.codigoDiagnosticoRelacionado2 = codigoDiagnosticoRelacionado2;
	}

	public String getCodigoDiagnosticoRelacionado3() {
		return codigoDiagnosticoRelacionado3;
	}

	public void setCodigoDiagnosticoRelacionado3(String codigoDiagnosticoRelacionado3) {
		this.codigoDiagnosticoRelacionado3 = codigoDiagnosticoRelacionado3;
	}

	public List<Procedimiento> getProcedimientos() {
		if(procedimientos == null)
			procedimientos = new ArrayList<Procedimiento>();
		return procedimientos;
	}

	public void setProcedimientos(List<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}

	public List<ProcedimientoOrdenado> getProcedimientosOrdenados() {
		if(procedimientosOrdenados == null)
			procedimientosOrdenados = new ArrayList<ProcedimientoOrdenado>();
		return procedimientosOrdenados;
	}

	public void setProcedimientosOrdenados(List<ProcedimientoOrdenado> procedimientosOrdenados) {
		this.procedimientosOrdenados = procedimientosOrdenados;
	}

	public List<Medicamento> getMedicamentos() {
		if(medicamentos == null)
			medicamentos = new ArrayList<Medicamento>();
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getProcedimientoConsulta() {
		return procedimientoConsulta;
	}

	public void setProcedimientoConsulta(String procedimientoConsulta) {
		this.procedimientoConsulta = procedimientoConsulta;
	}

	public String getCupProcedimientoConsulta() {
		return cupProcedimientoConsulta;
	}

	public void setCupProcedimientoConsulta(String cupProcedimientoConsulta) {
		this.cupProcedimientoConsulta = cupProcedimientoConsulta;
	}

	public List<Remision> getRemisiones() {
		if(remisiones == null)
			remisiones = new ArrayList<Remision>();
		return remisiones;
	}

	public void setRemisiones(List<Remision> remisiones) {
		this.remisiones = remisiones;
	}

	public Integer getContratoId() {
		return contratoId;
	}

	public void setContratoId(Integer contratoId) {
		this.contratoId = contratoId;
	}
	
	
}
