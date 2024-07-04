/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de trabajo voluntario.");

        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "¿Desea iniciar el registro de trabajo voluntario?",
                    "Inicio de registro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Sí", "No"},
                    "No");

            if (opcion == JOptionPane.YES_OPTION) {
                iniciarRegistro();
            }
        } while (opcion == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Programa finalizado.", "Fin del programa", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void iniciarRegistro() {
        String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de registro (formato dd-mm-aaaa):");

        RegistroVoluntario registro = new RegistroVoluntario();
        registrarSemana(registro, fecha, 1);
        registrarSemana(registro, fecha, 2);
    }

    public static void registrarSemana(RegistroVoluntario registro, String fecha, int semana) {
        JOptionPane.showMessageDialog(null, "Registrando semana " + semana + " para la fecha " + fecha);

        for (int i = 0; i < 2; i++) { // Se registran dos voluntarios por semana
            String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
            String apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido:");
            double horas = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad de horas laboradas:"));

            String tipoUsuario = JOptionPane.showInputDialog(null, "¿Es usted voluntario de la asociación de desarrollo? (s/n):");
            String idVoluntario = "";
            String cedula = "";
            String telefono = "";

            if (tipoUsuario.equalsIgnoreCase("s")) {
                idVoluntario = JOptionPane.showInputDialog(null, "Ingrese su ID de voluntario:");
            } else if (tipoUsuario.equalsIgnoreCase("n")) {
                cedula = JOptionPane.showInputDialog(null, "Ingrese su número de cédula:");
                telefono = JOptionPane.showInputDialog(null, "Ingrese su número de teléfono:");
            }

            String tipoVoluntariado = JOptionPane.showInputDialog(null, "Ingrese el tipo de voluntariado realizado (Educación/Ambiental/Trabajo manual):");
            String subtipo = "";

            if (tipoVoluntariado.equalsIgnoreCase("educación")) {
                subtipo = JOptionPane.showInputDialog(null, "Ingrese el subtipo de educación (Curso impartido/Centro educativo):");
            } else if (tipoVoluntariado.equalsIgnoreCase("ambiental")) {
                subtipo = JOptionPane.showInputDialog(null, "Ingrese el subtipo ambiental (Lugar de aplicación/Organización relacionada):");
            } else if (tipoVoluntariado.equalsIgnoreCase("trabajo manual")) {
                subtipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de trabajo manual realizado (Tipo de trabajo/Lugar de aplicación):");
            }

            Voluntario voluntario = new Voluntario(nombre, apellido, horas, tipoUsuario,
                                                   idVoluntario, cedula, telefono,
                                                   tipoVoluntariado, subtipo);
            registro.agregarVoluntario(voluntario);
        }

        registro.generarReporte(fecha, semana);
    }
}
