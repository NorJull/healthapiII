package com.vamosaprogramar.umedicalapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;

@Entity
@Table(name = "registro_odontologia")
public class RegistroOdontologia {

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

	@Column(name = "tratamiento_medico")
	private String tratamientoMedico;

	@Column(name = "reacciones_alergicas")
	private String reaccionesAlergicas;

	@Column(name = "irradiaciones")
	private String irradiaciones;

	@Column(name = "enfermedades_respiratorias")
	private String enfermedadesRespiratorias;

	@Column(name = "diabetes")
	private String diabetes;

	@Column(name = "hepatitis")
	private String hepatitis;

	@Column(name = "ingestion_medicamentos")
	private String ingestionMedicamentos;

	@Column(name = "hemorragias")
	private String hemorragias;

	@Column(name = "sinucitis")
	private String sinucitis;

	@Column(name = "cardiopatias")
	private String cardiopatias;

	@Column(name = "fiebre_reumatica")
	private String fiebreReumatica;

	@Column(name = "hipertension")
	private String hipertension;

	@Column(name = "otras_enfermedades")
	private String otrasEnfermedades;

	@Column(name = "art_temp_mandibular")
	private String artTempMandibular;

	@Column(name = "lengua")
	private String lengua;

	@Column(name = "piso_boca")
	private String pisoBoca;

	@Column(name = "glandulas_salivales")
	private String glandulasSalivales;

	@Column(name = "senos_maxilares")
	private String senosMaxilares;

	@Column(name = "sistema_nervioso")
	private String sistemaNervioso;

	@Column(name = "sistema_linfatico_regional")
	private String sistemaLinfaticoRegional;

	@Column(name = "labios")
	private String labios;

	@Column(name = "paladar")
	private String paladar;

	@Column(name = "carrollos")
	private String carrollos;

	@Column(name = "maxilares")
	private String maxilares;

	@Column(name = "musculos_masticadores")
	private String musculosMasticadores;

	@Column(name = "sistema_vascular")
	private String sistemaVascular;

	@Column(name = "funcion_de_oclusion")
	private String funcionDeOclusion;

	@Column(name = "supernumerarios")
	private String supernumerarios;

	@Column(name = "manchas")
	private String manchas;

	@Column(name = "placa_blanda")
	private String placaBlanda;

	@Column(name = "abrasion")
	private String abrasion;

	@Column(name = "patologia_pulpar")
	private String patologiaPulpar;

	@Column(name = "placa_calcificada")
	private String placaCalcificada;

	@Column(name = "otras_observaciones_orales")
	private String otrasObservacionesOrales;

	@Column(name = "dyp_presuntivo")
	private String dypPresuntivo;

	@Column(name = "dyp_definitivo")
	private String dypDefinitivo;

	@Column(name = "dyp_pronostico")
	private String dypPronostico;

	@Column(name = "plan_operatoria")
	private String planOperatoria;

	@Column(name = "plan_medicina_oral")
	private String planMedicinaOral;

	@Column(name = "plan_protesis")
	private String planProtesis;

	@Column(name = "plan_periodoncia")
	private String planPeriodoncia;

	@Column(name = "plan_cirugia_oral")
	private String planCirugiaOral;

	@Column(name = "plan_ortodoncia")
	private String planOrtodoncia;

	@Column(name = "plan_endodoncia")
	private String planEndodoncia;

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

	@OneToMany(mappedBy = "registroOdontologia", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<ProcedimientoOdontologia> procedimientoOdontologias;

	@OneToMany(mappedBy = "registroOdontologia", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<ProcedimientoOrdenadoOdontologia> procedimientoOrdenadoOdontologias;

	@OneToMany(mappedBy = "registroOdontologia", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<MedicamentoOdontologia> medicamentoOdontologias;

	@OneToMany(mappedBy = "registroOdontologia", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<RemisionOdontologia> remisionOdontologias;

	public RegistroOdontologia() {
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

	public String getTratamientoMedico() {
		return tratamientoMedico;
	}

	public void setTratamientoMedico(String tratamientoMedico) {
		this.tratamientoMedico = tratamientoMedico;
	}

	public String getReaccionesAlergicas() {
		return reaccionesAlergicas;
	}

	public void setReaccionesAlergicas(String reaccionesAlergicas) {
		this.reaccionesAlergicas = reaccionesAlergicas;
	}

	public String getIrradiaciones() {
		return irradiaciones;
	}

	public void setIrradiaciones(String irradiaciones) {
		this.irradiaciones = irradiaciones;
	}

	public String getEnfermedadesRespiratorias() {
		return enfermedadesRespiratorias;
	}

	public void setEnfermedadesRespiratorias(String enfermedadesRespiratorias) {
		this.enfermedadesRespiratorias = enfermedadesRespiratorias;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getHepatitis() {
		return hepatitis;
	}

	public void setHepatitis(String hepatitis) {
		this.hepatitis = hepatitis;
	}

	public String getIngestionMedicamentos() {
		return ingestionMedicamentos;
	}

	public void setIngestionMedicamentos(String ingestionMedicamentos) {
		this.ingestionMedicamentos = ingestionMedicamentos;
	}

	public String getHemorragias() {
		return hemorragias;
	}

	public void setHemorragias(String hemorragias) {
		this.hemorragias = hemorragias;
	}

	public String getSinucitis() {
		return sinucitis;
	}

	public void setSinucitis(String sinucitis) {
		this.sinucitis = sinucitis;
	}

	public String getCardiopatias() {
		return cardiopatias;
	}

	public void setCardiopatias(String cardiopatias) {
		this.cardiopatias = cardiopatias;
	}

	public String getFiebreReumatica() {
		return fiebreReumatica;
	}

	public void setFiebreReumatica(String fiebreReumatica) {
		this.fiebreReumatica = fiebreReumatica;
	}

	public String getHipertension() {
		return hipertension;
	}

	public void setHipertension(String hipertension) {
		this.hipertension = hipertension;
	}

	public String getOtrasEnfermedades() {
		return otrasEnfermedades;
	}

	public void setOtrasEnfermedades(String otrasEnfermedades) {
		this.otrasEnfermedades = otrasEnfermedades;
	}

	public String getArtTempMandibular() {
		return artTempMandibular;
	}

	public void setArtTempMandibular(String artTempMandibular) {
		this.artTempMandibular = artTempMandibular;
	}

	public String getLengua() {
		return lengua;
	}

	public void setLengua(String lengua) {
		this.lengua = lengua;
	}

	public String getPisoBoca() {
		return pisoBoca;
	}

	public void setPisoBoca(String pisoBoca) {
		this.pisoBoca = pisoBoca;
	}

	public String getGlandulasSalivales() {
		return glandulasSalivales;
	}

	public void setGlandulasSalivales(String glandulasSalivales) {
		this.glandulasSalivales = glandulasSalivales;
	}

	public String getSenosMaxilares() {
		return senosMaxilares;
	}

	public void setSenosMaxilares(String senosMaxilares) {
		this.senosMaxilares = senosMaxilares;
	}

	public String getSistemaNervioso() {
		return sistemaNervioso;
	}

	public void setSistemaNervioso(String sistemaNervioso) {
		this.sistemaNervioso = sistemaNervioso;
	}

	public String getSistemaLinfaticoRegional() {
		return sistemaLinfaticoRegional;
	}

	public void setSistemaLinfaticoRegional(String sistemaLinfaticoRegional) {
		this.sistemaLinfaticoRegional = sistemaLinfaticoRegional;
	}

	public String getLabios() {
		return labios;
	}

	public void setLabios(String labios) {
		this.labios = labios;
	}

	public String getPaladar() {
		return paladar;
	}

	public void setPaladar(String paladar) {
		this.paladar = paladar;
	}

	public String getCarrollos() {
		return carrollos;
	}

	public void setCarrollos(String carrollos) {
		this.carrollos = carrollos;
	}

	public String getMaxilares() {
		return maxilares;
	}

	public void setMaxilares(String maxilares) {
		this.maxilares = maxilares;
	}

	public String getMusculosMasticadores() {
		return musculosMasticadores;
	}

	public void setMusculosMasticadores(String musculosMasticadores) {
		this.musculosMasticadores = musculosMasticadores;
	}

	public String getSistemaVascular() {
		return sistemaVascular;
	}

	public void setSistemaVascular(String sistemaVascular) {
		this.sistemaVascular = sistemaVascular;
	}

	public String getFuncionDeOclusion() {
		return funcionDeOclusion;
	}

	public void setFuncionDeOclusion(String funcionDeOclusion) {
		this.funcionDeOclusion = funcionDeOclusion;
	}

	public String getSupernumerarios() {
		return supernumerarios;
	}

	public void setSupernumerarios(String supernumerarios) {
		this.supernumerarios = supernumerarios;
	}

	public String getManchas() {
		return manchas;
	}

	public void setManchas(String manchas) {
		this.manchas = manchas;
	}

	public String getPlacaBlanda() {
		return placaBlanda;
	}

	public void setPlacaBlanda(String placaBlanda) {
		this.placaBlanda = placaBlanda;
	}

	public String getAbrasion() {
		return abrasion;
	}

	public void setAbrasion(String abrasion) {
		this.abrasion = abrasion;
	}

	public String getPatologiaPulpar() {
		return patologiaPulpar;
	}

	public void setPatologiaPulpar(String patologiaPulpar) {
		this.patologiaPulpar = patologiaPulpar;
	}

	public String getPlacaCalcificada() {
		return placaCalcificada;
	}

	public void setPlacaCalcificada(String placaCalcificada) {
		this.placaCalcificada = placaCalcificada;
	}

	public String getOtrasObservacionesOrales() {
		return otrasObservacionesOrales;
	}

	public void setOtrasObservacionesOrales(String otrasObservacionesOrales) {
		this.otrasObservacionesOrales = otrasObservacionesOrales;
	}

	public String getDypPresuntivo() {
		return dypPresuntivo;
	}

	public void setDypPresuntivo(String dypPresuntivo) {
		this.dypPresuntivo = dypPresuntivo;
	}

	public String getDypDefinitivo() {
		return dypDefinitivo;
	}

	public void setDypDefinitivo(String dypDefinitivo) {
		this.dypDefinitivo = dypDefinitivo;
	}

	public String getDypPronostico() {
		return dypPronostico;
	}

	public void setDypPronostico(String dypPronostico) {
		this.dypPronostico = dypPronostico;
	}

	public String getPlanOperatoria() {
		return planOperatoria;
	}

	public void setPlanOperatoria(String planOperatoria) {
		this.planOperatoria = planOperatoria;
	}

	public String getPlanMedicinaOral() {
		return planMedicinaOral;
	}

	public void setPlanMedicinaOral(String planMedicinaOral) {
		this.planMedicinaOral = planMedicinaOral;
	}

	public String getPlanProtesis() {
		return planProtesis;
	}

	public void setPlanProtesis(String planProtesis) {
		this.planProtesis = planProtesis;
	}

	public String getPlanPeriodoncia() {
		return planPeriodoncia;
	}

	public void setPlanPeriodoncia(String planPeriodoncia) {
		this.planPeriodoncia = planPeriodoncia;
	}

	public String getPlanCirugiaOral() {
		return planCirugiaOral;
	}

	public void setPlanCirugiaOral(String planCirugiaOral) {
		this.planCirugiaOral = planCirugiaOral;
	}

	public String getPlanOrtodoncia() {
		return planOrtodoncia;
	}

	public void setPlanOrtodoncia(String planOrtodoncia) {
		this.planOrtodoncia = planOrtodoncia;
	}

	public String getPlanEndodoncia() {
		return planEndodoncia;
	}

	public void setPlanEndodoncia(String planEndodoncia) {
		this.planEndodoncia = planEndodoncia;
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

	public List<ProcedimientoOdontologia> getProcedimientoOdontologias() {
		return procedimientoOdontologias;
	}

	public void setProcedimientoOdontologias(List<ProcedimientoOdontologia> procedimientoOdontologias) {
		this.procedimientoOdontologias = procedimientoOdontologias;
	}

	public List<ProcedimientoOrdenadoOdontologia> getProcedimientoOrdenadoOdontologias() {
		return procedimientoOrdenadoOdontologias;
	}

	public void setProcedimientoOrdenadoOdontologias(List<ProcedimientoOrdenadoOdontologia> procedimientoOrdenadoOdontologias) {
		this.procedimientoOrdenadoOdontologias = procedimientoOrdenadoOdontologias;
	}

	public List<MedicamentoOdontologia> getMedicamentoOdontologias() {
		return medicamentoOdontologias;
	}

	public void setMedicamentoOdontologias(List<MedicamentoOdontologia> medicamentoOdontologias) {
		this.medicamentoOdontologias = medicamentoOdontologias;
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

	public List<RemisionOdontologia> getRemisionOdontologias() {
		return remisionOdontologias;
	}

	public void setRemisionOdontologias(List<RemisionOdontologia> remisionOdontologias) {
		this.remisionOdontologias = remisionOdontologias;
	}

	public Integer getContratoId() {
		return contratoId;
	}

	public void setContratoId(Integer contratoId) {
		this.contratoId = contratoId;
	}
	
}
