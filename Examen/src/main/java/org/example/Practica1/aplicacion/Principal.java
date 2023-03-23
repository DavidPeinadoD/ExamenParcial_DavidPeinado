package org.example.Practica1.aplicacion;

import org.example.Practica1.mates.Matematicas;
public class Principal {
    public static void main(String[] args) {
        System.out.println("El número PI calculado ha sido: " + Matematicas.generarNumeroPi(10000000));
    }
}