package com.salsge.demo.Legajo;

import com.salsge.demo.Categorias.Categoria;
import com.salsge.demo.Employees.Employee;
import com.salsge.demo.Novedades.Novedad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "legajo")
public class Legajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    private Employee employee;

    @OneToMany(mappedBy = "legajo", cascade = CascadeType.ALL)
    private List<Novedad> novedades;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String numeroDeLegajo;

    @NotBlank
    @Column(nullable = false)
    private String lastNames;

    @NotBlank
    @Column(nullable = false)
    private String names;

    @NotBlank
    @Column(nullable = false)
    private String direccion;

    @Positive
    @Column(nullable = false)
    private Integer numeroDeDireccion;

    @Positive
    private Integer piso;
    @Positive
    private Integer depto;

    @NotBlank
    @Column(nullable = false)
    private String codigoPostal;

    @NotBlank
    @Column(nullable = false)
    private String localidad;

    @NotBlank
    @Column(nullable = false)
    private String dni;

    @NotBlank
    @Column(nullable = false)
    private String cuit;

    @NotBlank
    @Column(nullable = false)
    private String telefono;

    @NotBlank
    @Column(nullable = false)
    private String telefonoDeEmergencia;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;

    @NotNull
    @Column(nullable = false)
    private LocalDate fechaDeIngreso;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer antiguedadReconocida;

    @NotBlank
    @Column(nullable = false)
    private String sexo;

    @NotBlank
    @Column(nullable = false)
    private String estadoCivil;

    @NotBlank
    @Column(nullable = false)
    private String cbu;

    @NotBlank
    @Column(nullable = false)
    private String cta;

    @NotBlank
    @Column(nullable = false)
    private String banco;

    @Positive
    @Column(nullable = true)
    private BigDecimal sueldo;

    @NotBlank
    @Column(nullable = false)
    private String tipoEmpleado;

    @NotBlank
    @Column(nullable = false)
    private String convenio;

    @NotBlank
    @Column(nullable = false)
    private String obraSocial;

    @NotBlank
    @Column(nullable = false)
    private String puesto;

    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private Categoria categoria;

    @NotBlank
    @Column(nullable = false)
    private String area;

    @Positive
    @Column(nullable = false)
    private Integer codigoActividad;

    @Positive
    @Column(nullable = false)
    private Integer codigoCondicion;

    @Positive
    @Column(nullable = false)
    private Integer codigoIncapacidad;

    @NotBlank
    @Column(nullable = false)
    private String situacionRevista;

    private Integer codigoZona;

    @NotBlank
    @Column(nullable = false)
    private String modalidadTrabajo;


    // Constructores
    public Legajo() {};

    public Legajo(Long id, Employee employee, String numeroDeLegajo) {
        this.id = id;
        this.employee = employee;
        this.numeroDeLegajo = numeroDeLegajo;
    }

    public Legajo(Employee employee, String numeroDeLegajo) {
        this.employee = employee;
        this.numeroDeLegajo = numeroDeLegajo;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNumeroDeLegajo() {
        return numeroDeLegajo;
    }

    public void setNumeroDeLegajo(String numeroDeLegajo) {
        this.numeroDeLegajo = numeroDeLegajo;
    }

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroDeDireccion() {
        return numeroDeDireccion;
    }

    public void setNumeroDeDireccion(Integer numeroDeDireccion) {
        this.numeroDeDireccion = numeroDeDireccion;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getDepto() {
        return depto;
    }

    public void setDepto(Integer depto) {
        this.depto = depto;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoDeEmergencia() {
        return telefonoDeEmergencia;
    }

    public void setTelefonoDeEmergencia(String telefonoDeEmergencia) {
        this.telefonoDeEmergencia = telefonoDeEmergencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public @PositiveOrZero Integer getAntiguedadReconocida() {
        return antiguedadReconocida;
    }

    public void setAntiguedadReconocida(@PositiveOrZero Integer antiguedadReconocida) {
        this.antiguedadReconocida = antiguedadReconocida;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public @NotBlank String getPuesto() {
        return puesto;
    }

    public void setPuesto(@NotBlank String puesto) {
        this.puesto = puesto;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public @NotBlank String getArea() {
        return area;
    }

    public void setArea(@NotBlank String area) {
        this.area = area;
    }

    public @Positive Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(@Positive Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public @Positive Integer getCodigoCondicion() {
        return codigoCondicion;
    }

    public void setCodigoCondicion(@Positive Integer codigoCondicion) {
        this.codigoCondicion = codigoCondicion;
    }

    public @Positive Integer getCodigoIncapacidad() {
        return codigoIncapacidad;
    }

    public void setCodigoIncapacidad(@Positive Integer codigoIncapacidad) {
        this.codigoIncapacidad = codigoIncapacidad;
    }

    public @NotBlank String getSituacionRevista() {
        return situacionRevista;
    }

    public void setSituacionRevista(@NotBlank String situacionRevista) {
        this.situacionRevista = situacionRevista;
    }

    public Integer getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(Integer codigoZona) {
        this.codigoZona = codigoZona;
    }

    public @NotBlank String getModalidadTrabajo() {
        return modalidadTrabajo;
    }

    public void setModalidadTrabajo(@NotBlank String modalidadTrabajo) {
        this.modalidadTrabajo = modalidadTrabajo;
    }
}
