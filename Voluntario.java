/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

public class Voluntario {
    private String nombre;
    private String apellido;
    private double horas;
    private String tipoUsuario; //'s' para voluntario de la asociación, 'n' para no voluntario según las indicaciones dadas por el profesor
    private String idVoluntario; //ID del voluntario si es de la asociación según las indicaciones dadas por el profesor
    private String cedula; //Número de cédula si no es voluntario de la asociación según las indicaciones dadas por el profesor
    private String telefono; //Teléfono si no es voluntario de la asociación según las indicaciones dadas por el profesor
    private String tipoVoluntariado;
    private String subtipo;

    //Constructor
    public Voluntario(String nombre, String apellido, double horas, String tipoUsuario,
                      String idVoluntario, String cedula, String telefono,
                      String tipoVoluntariado, String subtipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.horas = horas;
        this.tipoUsuario = tipoUsuario;
        this.idVoluntario = idVoluntario;
        this.cedula = cedula;
        this.telefono = telefono;
        this.tipoVoluntariado = tipoVoluntariado;
        this.subtipo = subtipo;
    }

    //Métodos getters para la información de la persona
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getHoras() {
        return horas;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getIdVoluntario() {
        return idVoluntario;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoVoluntariado() {
        return tipoVoluntariado;
    }

    public String getSubtipo() {
        return subtipo;
    }
}
