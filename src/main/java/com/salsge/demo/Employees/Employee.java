package com.salsge.demo.Employees;

import com.salsge.demo.Legajo.Legajo;
import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    @OneToOne(mappedBy = "employee")
    private Legajo legajo;

    private String fullName;
    private Integer age;
    private Date fechaNacimiento;
    private String estadoCivil;
    private String sexo;

    public Employee() {}

    public Employee(Long id, String fullName, Integer age, Date fechaNacimiento, String estadoCivil, String sexo) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }

    public Employee(String fullName, Integer age, Date fechaNacimiento, String estadoCivil, String sexo) {
        this.fullName = fullName;
        this.age = age;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }

    // Getters  and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // ToString method
    @Override
    public String toString() {
        return "Empleado N°"+ id + " " + fullName +
                ", age: " + age;
    }

    // Function for later
    /*
    public void assignLegajo(Legajo legajo) {
        this.legajo = legajo;
        legajo.setEmployee(this);
    }
    */

}
