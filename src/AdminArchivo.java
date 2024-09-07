import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class AdminArchivo {

    // Lee el contenido de un archivo y lo devuelve como una cadena
    public String leerArchivo(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
    }

    // Escribe el contenido en un archivo en la ruta especificada
    public void escribirArchivo(String rutaArchivo, String contenido) throws IOException {
        Files.write(Paths.get(rutaArchivo), contenido.getBytes());
    }

    // Solicita al usuario la ruta del archivo para leer
    public String solicitarRutaLectura() {
        System.out.print("Ingrese la ruta del archivo a leer: ");
        return new Scanner(System.in).nextLine();
    }

    // Solicita al usuario la ruta del archivo para guardar
    public String solicitarRutaGuardar() {
        System.out.print("Ingrese la ruta del archivo para guardar: ");
        return new Scanner(System.in).nextLine();
    }
}
