package bd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    List <String> lista;
    //Cargar el archivo txt
    private final String archivo = "C:/Users/admin/IdeaProjects/TP2-RECCHIA/src/main/java/bd/frases.txt";

    //Constructor de la clase
    public BaseDeDatos() {
        lista = new ArrayList<>();
        cargarDesdeArchivo();
    }

    //Metodo para insertar una nueva frase a la lista
    public void insertarTexto(String texto){
        lista.add(texto);
        guardarEnArchivo(texto);
    }

    //Metodo para establecer la lista de frases
    public void setLista(List <String> lista) {
        this.lista = lista;
    }

    //Metodo para obtener la lista de frases
    public List<String> getLista() {
        return lista;
    }

    //Metodo para obtener la lista de frases como un String
    public String getListaComoString() {
        return String.join(", ", lista);
    }

    //Metodo para contar la cantidad de frases
    public int contarFrases() {
        return lista.size();
    }

    //Metodo para editar una frase de la lista
    public void editarFrase(int indice, String nuevaFrase) {
        if (indice >= 0 && indice < lista.size()) {
            lista.set(indice, nuevaFrase); // Modificamos la frase en la lista
            guardarEnArchivo(nuevaFrase); // Guardar la lista completa en el archivo
            System.out.println("Frase editada con éxito.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    //Metodo para guardar una nueva frase en el archivo
    public void guardarEnArchivo(String texto){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(texto);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la frase: " + e.getMessage());
        }
    }

    //Metodo para cargar las frases desde el archivo al iniciar el programa
    private void cargarDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lista.add(linea); // Cargar cada línea (frase) en la lista
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo, se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al cargar las frases: " + e.getMessage());
        }
    }
}
