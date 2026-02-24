package com.salsge.demo.Employees;

import com.salsge.demo.Legajo.Legajo;
import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "employee")
    private Legajo legajo;

    private String fullName;

    public Employee() {}

    public Employee(Long id, Legajo legajo, String fullName) {
        this.id = id;
        this.legajo = legajo;
        this.fullName = fullName;
    }

    public Employee(Legajo legajo, String fullName) {
        this.legajo = legajo;
        this.fullName = fullName;
    }

    // Getters  and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Legajo getLegajo() {
        return legajo;
    }

    public void setLegajo(Legajo legajo) {
        this.legajo = legajo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // ToString method
    @Override
    public String toString() {
        return "Empleado N°" + this.id + " " + this.fullName;
    }

    // Function for later
    /*
    public void assignLegajo(Legajo legajo) {
        this.legajo = legajo;
        legajo.setEmployee(this);
    }
    */

}
