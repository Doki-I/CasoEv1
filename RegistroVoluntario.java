/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.io.FileWriter;
import java.io.IOException;

public class RegistroVoluntario {
    private Voluntario[] voluntarios;
    private int contador;

    // Constructor
    public RegistroVoluntario() {
        voluntarios = new Voluntario[4]; //Capacidad para 4 voluntarios por semana debido a que el codigo sea más sencillo debido a que en las indicaciones no sale ninguna pauta de cuanta cantidad de gente puedo agregar le puse un limite
        contador = 0;
    }

    //Este metodo es para agregar un voluntario al registro
    public void agregarVoluntario(Voluntario voluntario) {
        if (contador < voluntarios.length) {
            voluntarios[contador++] = voluntario;
        } else {
            System.out.println("No se pueden agregar más voluntarios para esta semana.");
        }
    }

    //Cálculo para obtener el voluntario con más horas
    public Voluntario obtenerVoluntarioConMasHoras() {
        if (contador == 0) {
            return null;
        }

        Voluntario maxHoras = voluntarios[0];
        for (int i = 1; i < contador; i++) {
            if (voluntarios[i].getHoras() > maxHoras.getHoras()) {
                maxHoras = voluntarios[i];
            }
        }
        return maxHoras;
    }

    //Cálculo para obtener el voluntario con menos horas
    public Voluntario obtenerVoluntarioConMenosHoras() {
        if (contador == 0) {
            return null;
        }

        Voluntario minHoras = voluntarios[0];
        for (int i = 1; i < contador; i++) {
            if (voluntarios[i].getHoras() < minHoras.getHoras()) {
                minHoras = voluntarios[i];
            }
        }
        return minHoras;
    }

    //Cálculo para obtener el promedio de horas de todos los voluntarios
    public double obtenerPromedioHoras() {
        if (contador == 0) {
            return 0.0;
        }

        double totalHoras = 0;
        for (int i = 0; i < contador; i++) {
            totalHoras += voluntarios[i].getHoras();
        }
        return totalHoras / contador;
    }

    //Este metodo es para generar el reporte
    public void generarReporte(String fecha, int semana) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de voluntariado para la fecha ").append(fecha).append(", semana ").append(semana).append("\n\n");

        for (int i = 0; i < contador; i++) {
            Voluntario v = voluntarios[i];
            reporte.append("Nombre: ").append(v.getNombre()).append(" ").append(v.getApellido()).append("\n");
            reporte.append("Horas laboradas: ").append(v.getHoras()).append(" horas\n");
            reporte.append("Tipo de usuario: ").append(v.getTipoUsuario().equals("s") ? "Voluntario" : "No voluntario").append("\n");
            if (v.getTipoUsuario().equals("n")) {
                reporte.append("Información de contacto: Cédula: ").append(v.getCedula()).append(", Teléfono: ").append(v.getTelefono()).append("\n");
            }
            reporte.append("Tipo de voluntariado: ").append(v.getTipoVoluntariado()).append("\n");
            reporte.append("Subtipo: ").append(v.getSubtipo()).append("\n\n");
        }

        Voluntario maxHoras = obtenerVoluntarioConMasHoras();
        if (maxHoras != null) {
            reporte.append("Persona con mayor cantidad de horas: ").append(maxHoras.getNombre()).append(" ").append(maxHoras.getApellido()).append(" (").append(maxHoras.getHoras()).append(" horas)\n");
        }

        Voluntario minHoras = obtenerVoluntarioConMenosHoras();
        if (minHoras != null) {
            reporte.append("Persona con menor cantidad de horas: ").append(minHoras.getNombre()).append(" ").append(minHoras.getApellido()).append(" (").append(minHoras.getHoras()).append(" horas)\n");
        }

        double promedioHoras = obtenerPromedioHoras();
        reporte.append("Promedio de horas por voluntario: ").append(promedioHoras).append(" horas\n");

        String nombreArchivo = "reporte_" + fecha + "_semana" + semana + ".log";
        guardarReporte(nombreArchivo, reporte.toString());
        System.out.println("Se ha generado el reporte " + nombreArchivo);
    }

    //Este metodo es para guardar el reporte en un archivo especifico
    private void guardarReporte(String nombreArchivo, String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al crear el archivo de reporte: " + e.getMessage());
        }
    }
}
