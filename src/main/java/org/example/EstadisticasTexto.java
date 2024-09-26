package org.example;

public class EstadisticasTexto {

    public String contadorPalabras(String texto) {
        //Validar que no cuente los espacios en blanco como palabras
        String[] palabras = texto.trim().split("\\s+");
        return "Cantidad de palabras del texto: " + palabras.length;
    }

    public String contadorVocales(String texto) {
        int cantVocales;
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] letras = texto.toCharArray();
        cantVocales = 0;
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < vocales.length; j++) {
                if (letras[i] == vocales[j]) {
                    cantVocales++;
                }
            }
        }
        return "Cantidad de vocales del texto: " + cantVocales;
    }

    public String contadorConsonantes(String texto) {
        int cantConsonantes = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] letras = texto.toLowerCase().toCharArray(); //Convierto el texto a minúsculas

        for (char letra : letras) {
            if (Character.isLetter(letra) && !esVocal(letra, vocales)) {
                cantConsonantes++;
            }
        }
        return "Cantidad de consonantes del texto: " + cantConsonantes;
    }

    private boolean esVocal(char letra, char[] vocales) {
        for (char vocal : vocales) {
            if (letra == vocal) {
                return true;
            }
        }
        return false;
    }
}
