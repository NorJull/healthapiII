package com.vamosaprogramar.umedicalapi.entity;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;

import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "registro_aiepi")
public class RegistroAIEPI {
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
	
	@Column(name = "es_particular")
	private String esParticular;
	
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
	
	@Column(name = "codigo_diagnostico_principal")
	private String codigoDiagnosticoPrincipal;
	
	@Column(name = "codigo_diagnostico_relacionado_1")
	private String codigoDiagnosticoRelacionado1;
	
	@Column(name = "codigo_diagnostico_relacionado_2")
	private String codigoDiagnosticoRelacionado2;
	
	@Column(name = "codigo_diagnostico_relacionado_3")
	private String codigoDiagnosticoRelacionado3;
	
	@Column(name = "efermedad_actual")
	private String enfermedadActual;
	
	@Column(name = "beber_seno")
	private String beberSeno;
	
	@Column(name = "vomita_todo_ingerido")
	private String vomitaTodoIngerido;
	
	@Column(name = "convulciones")
	private String convulciones;

	@Column(name = "letargico_inconsciente")
	private String letargicoInconsciente;
	
	@Column(name = "dificultad_respirar")
	private String dificultadRespirar;

	@Column(name = "dificulad_respirar_dias")
	private int dificultadRespirarDias;

	@Column(name = "tiraje_subcostal")
	private String tirajeSubcostal;

	@Column(name = "estridor")
	private String estridor;
	
	@Column(name = "sibilancia")
	private String sibilancia;

	@Column(name = "diarrea")
	private String diarrea;

	@Column(name = "diarrea_dias")
	private int  diarreaDias;
	
	@Column(name = "sangre_heces")
	private String sangreHeces;

	@Column(name = "intranquilo_irritable")
	private String intranquiloIrritable;
	
	@Column(name = "ojos_hundidos")
	private String ojosHundidos;
	
	@Column(name = "dificultad_beber")
	private String dificultadBeber;

	@Column(name = "beber_con_sed")
	private String beberConSed;
	
	@Column(name = "fiebre")
	private String fiebre;
	
	@Column(name = "fiebre_dias")
	private int fiebreDias;

	@Column(name = "fiebre_cinco_dias")
	private String fiebreCincoDias;
	
	@Column(name = "quince_dias_riesgo")
	private String quinceDiasRiesgo;
	
	@Column(name = "nuca_rigida")
	private String nucaRigida;

	@Column(name = "aspecto_toxico")
	private String aspectoToxico;

	@Column(name = "dolor_abdominal")
	private String dolorAbdominal;

	@Column(name = "piel_humeda")
	private String pielHumeda;

	@Column(name = "evidencia_sangrado")
	private String evidenciaSangrado;

	@Column(name = "exantema_cutaneo")
	private String exantemaCutaneo;

	@Column(name = "tos_corriza_ojos_rojos")
	private String tosCorrizaOjosRojos;

	@Column(name = "problema_oido")
	private String problemaOido;

	@Column(name = "supuracion_oido")
	private String supuracionOido;

	@Column(name = "supuracion_dias")
	private int supuracionDias;

	@Column(name = "supuracion_veces")
	private int supuracionVeces;

	@Column(name = "timpano_rojo")
	private String timpanoRojo;

	@Column(name = "inflamacion_detras_oreja")
	private String inflamacionDetrasOreja;
	
	@Column(name = "problema_garganta")
	private String problemaGarganta;
	
	@Column(name = "dolor_garganta")
	private String dolorGarganta;

	@Column(name = "ganglios_cuello")
	private String gangliosCuello;

	@Column(name = "exodado_amigdalas")
	private String exodadoAmigdalas;
	
	@Column(name = "garganta_eritematosa")
	private String gargantaEritematosa;

	@Column(name = "lesion_fisica")
	private String lesionFisica;
	
	@Column(name = "lesion_fisica_genitales")
	private String lesionFisicaGenitales;
	
	@Column(name = "expresa_maltrato")
	private String expresaMaltrato;

	@Column(name = "cambio_comportamiento_nino")
	private String cambioComportamientoNino;
	
	@Column(name = "cambio_comportamiento_cuidadores")
	private String cambioComportamientoCuidadores;
	
	@Column(name = "higiene_descuidada")
	private String higieneDescuidada;
	
	@Column(name = "saludDescuidada")
	private String saludDescuidada;

	@Column(name = "discapacitado")
	private String discapacitado;

	@Column(name = "emaciacion")
	private String emaciacion;

	@Column(name = "palmas_palidas")
	private String palmasPalidas;
	
	@Column(name = "edema_pies")
	private String edemaPies;

	@Column(name = "actividades_edad")
	private String actividadesEdad;

	@Column(name = "actividades_edad_anterior")
	private String actividadesEdadAnterior;

	@Column(name = "embarazo")
	private String embarazo;
	
	@Column(name = "parto")
	private String parto;
	
	@Column(name = "peso_nacimiento")
	private double pesoNacimiento;
	
	@Column(name = "problema_nacimiento")
	private String problemaNacimiento;
	
	@Column(name = "problema_serio_salud")
	private String problemaSerioSalud;
	
	@Column(name = "padres_parientes")
	private String padresParientes;

	@Column(name = "familiar_problema_fisico_mental")
	private String familiarProblemaFisicoMental;

	@Column(name = "desarrollo_nino")
	private String desarrolloNino;
	
	@Column(name = "frecuencia_cardiaca")
	private int frecueciaCardiaca;
	
	@Column(name = "frecuenciaRespiratoria")
	private int frecuenciaRepiratoria;

	@Column(name = "tension")
	private String tension;
	
	@Column(name = "temperatura_corporal")
	private double temperaturaCorporal;
	
	@Column(name = "talla")
	private double talla;

	@Column(name = "peso")
	private double peso;
	
	@Column(name = "imc")
	private double imc;
	
	@Column(name = "signos_sintomas")
	private String signosSintomas;

	@Column(name = "volver_inmediato")
	private String volverInmediato;
	
	@Column(name = "volver_consulta_nino_sano")
	private String volverConsultaNinoSano;
	
	@Column(name = "volver_consulta_control")
	private String volverConsultaControl;
	
	@Column(name = "referido_consulta")
	private String referidoConsulta;
	
	@Column(name = "medidas_preventivas")
	private String medidasPreventivas;
	
	@Column(name = "recomendaciones_buen_trato")
	private String recomendacionesBuenTrato;
	
	
	@OneToMany(mappedBy = "registroAIEPI", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<ProcedimientoAIEPI> procedimientosAIEPIs;
	
	@OneToMany(mappedBy = "registroAIEPI", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<ProcedimientoOrdenadoAIEPI> procedimientosOrdenadoAIEPIs;

	@OneToMany(mappedBy = "registroAIEPI", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<MedicamentoAIEPI> medicamentosAIEPIs;

	@OneToMany(mappedBy = "registroAIEPI", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	private List<RemisionAIEPI> remisionAIEPIs;


	public RegistroAIEPI() {
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



	public String getEsParticular() {
		return esParticular;
	}



	public void setEsParticular(String esParticular) {
		this.esParticular = esParticular;
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



	public String getEnfermedadActual() {
		return enfermedadActual;
	}



	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}



	public String getBeberSeno() {
		return beberSeno;
	}



	public void setBeberSeno(String beberSeno) {
		this.beberSeno = beberSeno;
	}



	public String getVomitaTodoIngerido() {
		return vomitaTodoIngerido;
	}



	public void setVomitaTodoIngerido(String vomitaTodoIngerido) {
		this.vomitaTodoIngerido = vomitaTodoIngerido;
	}



	public String getConvulciones() {
		return convulciones;
	}



	public void setConvulciones(String convulciones) {
		this.convulciones = convulciones;
	}



	public String getLetargicoInconsciente() {
		return letargicoInconsciente;
	}



	public void setLetargicoInconsciente(String letargicoInconsciente) {
		this.letargicoInconsciente = letargicoInconsciente;
	}



	public String getDificultadRespirar() {
		return dificultadRespirar;
	}



	public void setDificultadRespirar(String dificultadRespirar) {
		this.dificultadRespirar = dificultadRespirar;
	}



	public int getDificultadRespirarDias() {
		return dificultadRespirarDias;
	}



	public void setDificultadRespirarDias(int dificultadRespirarDias) {
		this.dificultadRespirarDias = dificultadRespirarDias;
	}



	public String getTirajeSubcostal() {
		return tirajeSubcostal;
	}



	public void setTirajeSubcostal(String tirajeSubcostal) {
		this.tirajeSubcostal = tirajeSubcostal;
	}



	public String getEstridor() {
		return estridor;
	}



	public void setEstridor(String estridor) {
		this.estridor = estridor;
	}



	public String getSibilancia() {
		return sibilancia;
	}



	public void setSibilancia(String sibilancia) {
		this.sibilancia = sibilancia;
	}



	public String getDiarrea() {
		return diarrea;
	}



	public void setDiarrea(String diarrea) {
		this.diarrea = diarrea;
	}



	public int getDiarreaDias() {
		return diarreaDias;
	}



	public void setDiarreaDias(int diarreaDias) {
		this.diarreaDias = diarreaDias;
	}



	public String getSangreHeces() {
		return sangreHeces;
	}



	public void setSangreHeces(String sangreHeces) {
		this.sangreHeces = sangreHeces;
	}



	public String getIntranquiloIrritable() {
		return intranquiloIrritable;
	}



	public void setIntranquiloIrritable(String intranquiloIrritable) {
		this.intranquiloIrritable = intranquiloIrritable;
	}



	public String getOjosHundidos() {
		return ojosHundidos;
	}



	public void setOjosHundidos(String ojosHundidos) {
		this.ojosHundidos = ojosHundidos;
	}



	public String getDificultadBeber() {
		return dificultadBeber;
	}



	public void setDificultadBeber(String dificultadBeber) {
		this.dificultadBeber = dificultadBeber;
	}



	public String getBeberConSed() {
		return beberConSed;
	}



	public void setBeberConSed(String beberConSed) {
		this.beberConSed = beberConSed;
	}



	public String getFiebre() {
		return fiebre;
	}



	public void setFiebre(String fiebre) {
		this.fiebre = fiebre;
	}



	public int getFiebreDias() {
		return fiebreDias;
	}



	public void setFiebreDias(int fiebreDias) {
		this.fiebreDias = fiebreDias;
	}



	public String getFiebreCincoDias() {
		return fiebreCincoDias;
	}



	public void setFiebreCincoDias(String fiebreCincoDias) {
		this.fiebreCincoDias = fiebreCincoDias;
	}



	public String getQuinceDiasRiesgo() {
		return quinceDiasRiesgo;
	}



	public void setQuinceDiasRiesgo(String quinceDiasRiesgo) {
		this.quinceDiasRiesgo = quinceDiasRiesgo;
	}



	public String getNucaRigida() {
		return nucaRigida;
	}



	public void setNucaRigida(String nucaRigida) {
		this.nucaRigida = nucaRigida;
	}



	public String getAspectoToxico() {
		return aspectoToxico;
	}



	public void setAspectoToxico(String aspectoToxico) {
		this.aspectoToxico = aspectoToxico;
	}



	public String getDolorAbdominal() {
		return dolorAbdominal;
	}



	public void setDolorAbdominal(String dolorAbdominal) {
		this.dolorAbdominal = dolorAbdominal;
	}



	public String getPielHumeda() {
		return pielHumeda;
	}



	public void setPielHumeda(String pielHumeda) {
		this.pielHumeda = pielHumeda;
	}



	public String getEvidenciaSangrado() {
		return evidenciaSangrado;
	}



	public void setEvidenciaSangrado(String evidenciaSangrado) {
		this.evidenciaSangrado = evidenciaSangrado;
	}



	public String getExantemaCutaneo() {
		return exantemaCutaneo;
	}



	public void setExantemaCutaneo(String exantemaCutaneo) {
		this.exantemaCutaneo = exantemaCutaneo;
	}



	public String getTosCorrizaOjosRojos() {
		return tosCorrizaOjosRojos;
	}



	public void setTosCorrizaOjosRojos(String tosCorrizaOjosRojos) {
		this.tosCorrizaOjosRojos = tosCorrizaOjosRojos;
	}



	public String getProblemaOido() {
		return problemaOido;
	}



	public void setProblemaOido(String problemaOido) {
		this.problemaOido = problemaOido;
	}



	public String getSupuracionOido() {
		return supuracionOido;
	}



	public void setSupuracionOido(String supuracionOido) {
		this.supuracionOido = supuracionOido;
	}



	public int getSupuracionDias() {
		return supuracionDias;
	}



	public void setSupuracionDias(int supuracionDias) {
		this.supuracionDias = supuracionDias;
	}



	public int getSupuracionVeces() {
		return supuracionVeces;
	}



	public void setSupuracionVeces(int supuracionVeces) {
		this.supuracionVeces = supuracionVeces;
	}



	public String getTimpanoRojo() {
		return timpanoRojo;
	}



	public void setTimpanoRojo(String timpanoRojo) {
		this.timpanoRojo = timpanoRojo;
	}



	public String getInflamacionDetrasOreja() {
		return inflamacionDetrasOreja;
	}



	public void setInflamacionDetrasOreja(String inflamacionDetrasOreja) {
		this.inflamacionDetrasOreja = inflamacionDetrasOreja;
	}



	public String getProblemaGarganta() {
		return problemaGarganta;
	}



	public void setProblemaGarganta(String problemaGarganta) {
		this.problemaGarganta = problemaGarganta;
	}



	public String getDolorGarganta() {
		return dolorGarganta;
	}



	public void setDolorGarganta(String dolorGarganta) {
		this.dolorGarganta = dolorGarganta;
	}



	public String getGangliosCuello() {
		return gangliosCuello;
	}



	public void setGangliosCuello(String gangliosCuello) {
		this.gangliosCuello = gangliosCuello;
	}



	public String getExodadoAmigdalas() {
		return exodadoAmigdalas;
	}



	public void setExodadoAmigdalas(String exodadoAmigdalas) {
		this.exodadoAmigdalas = exodadoAmigdalas;
	}



	public String getGargantaEritematosa() {
		return gargantaEritematosa;
	}



	public void setGargantaEritematosa(String gargantaEritematosa) {
		this.gargantaEritematosa = gargantaEritematosa;
	}



	public String getLesionFisica() {
		return lesionFisica;
	}



	public void setLesionFisica(String lesionFisica) {
		this.lesionFisica = lesionFisica;
	}



	public String getLesionFisicaGenitales() {
		return lesionFisicaGenitales;
	}



	public void setLesionFisicaGenitales(String lesionFisicaGenitales) {
		this.lesionFisicaGenitales = lesionFisicaGenitales;
	}



	public String getExpresaMaltrato() {
		return expresaMaltrato;
	}



	public void setExpresaMaltrato(String expresaMaltrato) {
		this.expresaMaltrato = expresaMaltrato;
	}



	public String getCambioComportamientoNino() {
		return cambioComportamientoNino;
	}



	public void setCambioComportamientoNino(String cambioComportamientoNino) {
		this.cambioComportamientoNino = cambioComportamientoNino;
	}



	public String getCambioComportamientoCuidadores() {
		return cambioComportamientoCuidadores;
	}



	public void setCambioComportamientoCuidadores(String cambioComportamientoCuidadores) {
		this.cambioComportamientoCuidadores = cambioComportamientoCuidadores;
	}



	public String getHigieneDescuidada() {
		return higieneDescuidada;
	}



	public void setHigieneDescuidada(String higieneDescuidada) {
		this.higieneDescuidada = higieneDescuidada;
	}



	public String getSaludDescuidada() {
		return saludDescuidada;
	}



	public void setSaludDescuidada(String saludDescuidada) {
		this.saludDescuidada = saludDescuidada;
	}



	public String getDiscapacitado() {
		return discapacitado;
	}



	public void setDiscapacitado(String discapacitado) {
		this.discapacitado = discapacitado;
	}



	public String getEmaciacion() {
		return emaciacion;
	}



	public void setEmaciacion(String emaciacion) {
		this.emaciacion = emaciacion;
	}



	public String getPalmasPalidas() {
		return palmasPalidas;
	}



	public void setPalmasPalidas(String palmasPalidas) {
		this.palmasPalidas = palmasPalidas;
	}



	public String getEdemaPies() {
		return edemaPies;
	}



	public void setEdemaPies(String edemaPies) {
		this.edemaPies = edemaPies;
	}



	public String getActividadesEdad() {
		return actividadesEdad;
	}



	public void setActividadesEdad(String actividadesEdad) {
		this.actividadesEdad = actividadesEdad;
	}



	public String getActividadesEdadAnterior() {
		return actividadesEdadAnterior;
	}



	public void setActividadesEdadAnterior(String actividadesEdadAnterior) {
		this.actividadesEdadAnterior = actividadesEdadAnterior;
	}



	public String getEmbarazo() {
		return embarazo;
	}



	public void setEmbarazo(String embarazo) {
		this.embarazo = embarazo;
	}



	public String getParto() {
		return parto;
	}



	public void setParto(String parto) {
		this.parto = parto;
	}



	public double getPesoNacimiento() {
		return pesoNacimiento;
	}



	public void setPesoNacimiento(double pesoNacimiento) {
		this.pesoNacimiento = pesoNacimiento;
	}



	public String getProblemaNacimiento() {
		return problemaNacimiento;
	}



	public void setProblemaNacimiento(String problemaNacimiento) {
		this.problemaNacimiento = problemaNacimiento;
	}



	public String getProblemaSerioSalud() {
		return problemaSerioSalud;
	}



	public void setProblemaSerioSalud(String problemaSerioSalud) {
		this.problemaSerioSalud = problemaSerioSalud;
	}



	public String getPadresParientes() {
		return padresParientes;
	}



	public void setPadresParientes(String padresParientes) {
		this.padresParientes = padresParientes;
	}



	public String getFamiliarProblemaFisicoMental() {
		return familiarProblemaFisicoMental;
	}



	public void setFamiliarProblemaFisicoMental(String familiarProblemaFisicoMental) {
		this.familiarProblemaFisicoMental = familiarProblemaFisicoMental;
	}



	public String getDesarrolloNino() {
		return desarrolloNino;
	}



	public void setDesarrolloNino(String desarrolloNino) {
		this.desarrolloNino = desarrolloNino;
	}



	public int getFrecueciaCardiaca() {
		return frecueciaCardiaca;
	}



	public void setFrecueciaCardiaca(int frecueciaCardiaca) {
		this.frecueciaCardiaca = frecueciaCardiaca;
	}



	public int getFrecuenciaRepiratoria() {
		return frecuenciaRepiratoria;
	}



	public void setFrecuenciaRepiratoria(int frecuenciaRepiratoria) {
		this.frecuenciaRepiratoria = frecuenciaRepiratoria;
	}



	public String getTension() {
		return tension;
	}



	public void setTension(String tension) {
		this.tension = tension;
	}



	public double getTemperaturaCorporal() {
		return temperaturaCorporal;
	}



	public void setTemperaturaCorporal(double temperaturaCorporal) {
		this.temperaturaCorporal = temperaturaCorporal;
	}



	public double getTalla() {
		return talla;
	}



	public void setTalla(double talla) {
		this.talla = talla;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public double getImc() {
		return imc;
	}



	public void setImc(double imc) {
		this.imc = imc;
	}



	public String getSignosSintomas() {
		return signosSintomas;
	}



	public void setSignosSintomas(String signosSintomas) {
		this.signosSintomas = signosSintomas;
	}



	public String getVolverInmediato() {
		return volverInmediato;
	}



	public void setVolverInmediato(String volverInmediato) {
		this.volverInmediato = volverInmediato;
	}



	public String getVolverConsultaNinoSano() {
		return volverConsultaNinoSano;
	}



	public void setVolverConsultaNinoSano(String volverConsultaNinoSano) {
		this.volverConsultaNinoSano = volverConsultaNinoSano;
	}



	public String getVolverConsultaControl() {
		return volverConsultaControl;
	}



	public void setVolverConsultaControl(String volverConsultaControl) {
		this.volverConsultaControl = volverConsultaControl;
	}



	public String getReferidoConsulta() {
		return referidoConsulta;
	}



	public void setReferidoConsulta(String referidoConsulta) {
		this.referidoConsulta = referidoConsulta;
	}



	public String getMedidasPreventivas() {
		return medidasPreventivas;
	}



	public void setMedidasPreventivas(String medidasPreventivas) {
		this.medidasPreventivas = medidasPreventivas;
	}



	public String getRecomendacionesBuenTrato() {
		return recomendacionesBuenTrato;
	}



	public void setRecomendacionesBuenTrato(String recomendacionesBuenTrato) {
		this.recomendacionesBuenTrato = recomendacionesBuenTrato;
	}



	public List<ProcedimientoAIEPI> getProcedimientosAIEPIs() {
		return procedimientosAIEPIs;
	}



	public void setProcedimientosAIEPIs(List<ProcedimientoAIEPI> procedimientosAIEPIs) {
		this.procedimientosAIEPIs = procedimientosAIEPIs;
	}



	public List<ProcedimientoOrdenadoAIEPI> getProcedimientosOrdenadoAIEPIs() {
		return procedimientosOrdenadoAIEPIs;
	}



	public void setProcedimientosOrdenadoAIEPIs(List<ProcedimientoOrdenadoAIEPI> procedimientosOrdenadoAIEPIs) {
		this.procedimientosOrdenadoAIEPIs = procedimientosOrdenadoAIEPIs;
	}


	public List<MedicamentoAIEPI> getMedicamentosAIEPIs() {
		return medicamentosAIEPIs;
	}



	public void setMedicamentosAIEPIs(List<MedicamentoAIEPI> medicamentosAIEPIs) {
		this.medicamentosAIEPIs = medicamentosAIEPIs;
	}


	public List<RemisionAIEPI> getRemisionAIEPIs() {
		return remisionAIEPIs;
	}


	public void setRemisionAIEPIs(List<RemisionAIEPI> remisionAIEPIs) {
		this.remisionAIEPIs = remisionAIEPIs;
	}


}
