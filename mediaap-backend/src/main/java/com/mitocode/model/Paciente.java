package com.mitocode.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;


@ApiModel(description = "Información de paciente")
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
    @Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @ApiModelProperty(notes = "Apellido debe tener minimo 3 caracteres")
    @Size(min = 3, message = "Apellido debe tener minimo 3 caracteres")
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @ApiModelProperty(notes = "DNI debe tener 8 caracteres")
    @Size(min = 8,max = 8,message = "DNI debe tener 8 caracteres")
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @ApiModelProperty(notes = "Direccion debe tener minimo 3 caracteres")
    @Size(min = 3,max = 150,message = "Direccion debe tener minimo 3 caracteres")
    @Column(name = "direccion", nullable = true, length = 150)
    private String direccion;

    @ApiModelProperty(notes = "Telefono debe tener 8 caracteres")
    @Size(min = 9,max = 9,message = "Telefono debe tener 8 caracteres")
    @Column(name = "telefono", nullable = true, length = 9)
    private String telefono;


    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
