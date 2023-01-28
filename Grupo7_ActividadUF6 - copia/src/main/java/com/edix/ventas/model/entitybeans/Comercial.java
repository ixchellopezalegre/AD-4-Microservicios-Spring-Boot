package com.edix.ventas.model.entitybeans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comerciales")
public class Comercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comercial", nullable = false)
    private Integer idComercial;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido1", nullable = false, length = 100)
    private String apellido1;

    @Column(name = "apellido2", length = 100)
    private String apellido2;

    @Column(name = "comision")
    private Double comision;

    public Comercial() {
    }

    public Comercial(String nombre, String apellido1, String apellido2, Double comision) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.comision = comision;
    }

    public Integer getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(Integer idComercial) {
        this.idComercial = idComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comercial comercial = (Comercial) o;
        return Objects.equals(idComercial, comercial.idComercial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComercial);
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "id=" + idComercial +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", comision=" + comision +
                '}';
    }
}