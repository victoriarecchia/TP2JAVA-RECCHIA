package org.example;

import bd.BaseDeDatos;

import java.util.Scanner;

public class Aplicacion {
    static String mensajeDeBienvenida = "¡Bienvenid@ a la aplicación!";

    public static void main(String[] args) {

        //Mensaje de bienvenida
        System.out.println(mensajeDeBienvenida);
        Scanner scanner = new Scanner(System.in);

        //Creo BD
        BaseDeDatos bd = new BaseDeDatos();

        if (bd.contarFrases() > 0) {
            System.out.println("Frases almacenadas previamente: " + bd.getListaComoString());
        } else {
            System.out.println("No hay frases almacenadas.");
        }
        //Ingreso de texto
        System.out.println("Ingrese un texto: ");
        String texto = scanner.nextLine();

        //Validar que el texto no supere los 140 caracteres
        while (texto.length() > 140) {
            System.out.println("El texto no puede superar los 140 caracteres. Ingrese un texto: ");
            texto = scanner.nextLine();
        }

        bd.insertarTexto(texto);

        //Mostrar lista
        System.out.println("Textos ingresados: " + bd.getListaComoString());


        //Creo objetos de la clase EstadisticasTexto
        EstadisticasTexto cantPalabras = new EstadisticasTexto();
        EstadisticasTexto cantVocales = new EstadisticasTexto();
        EstadisticasTexto cantConsonantes = new EstadisticasTexto();

        //Cantidad de palabras del texto
        String cantidadPalabras = cantPalabras.contadorPalabras(texto);
        System.out.println(cantidadPalabras);

        //Cantidad de vocales del texto
        String cantidadVocales = cantVocales.contadorVocales(texto);
        System.out.println(cantidadVocales);

        //Cantidad de consonantes del texto
        String cantidadConsonantes = cantConsonantes.contadorConsonantes(texto);
        System.out.println(cantidadConsonantes);


        /*
        //Seleccionar y editar frase
        System.out.println("Ingrese el índice de la frase que desea editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); //Limpiar buffer
        System.out.println("Ingrese la nueva frase: ");
        String nuevaFrase = scanner.nextLine();

        //Editar la frase
        bd.editarFrase(indice, nuevaFrase);

        //Mostrar lista actualizada
        System.out.println("Lista actualizada: " + bd.getListaComoString());
*/
    }
}