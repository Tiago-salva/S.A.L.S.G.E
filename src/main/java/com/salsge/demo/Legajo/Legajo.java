package com.salsge.demo.Legajo;

import com.salsge.demo.Employees.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "legajo")
public class Legajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_id", nullable = false, unique = true)

    private Employee employee;

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

    @NotBlank
    @Column(nullable = false)
    private Integer numeroDeDireccion;

    private Integer piso;
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

    @NotBlank
    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;

    @NotBlank
    @Column(nullable = false)
    private LocalDate fechaDeIngreso;

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

    @NotBlank
    @Column(nullable = false)
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
}
