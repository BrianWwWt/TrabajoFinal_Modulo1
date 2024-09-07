import java.io.IOException;
import java.util.Scanner;

public class Encriptador {

    private final AdminArchivo adminArchivo = new AdminArchivo();
    private final Scanner entrada = new Scanner(System.in);

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println();
            System.out.println("---- MENÚ ENCRIPTADOR ----");
            System.out.println("1. Encriptar texto en consola.");
            System.out.println("2. Encriptar archivo de texto.");
            System.out.println("3. Regresar al menú principal.");
            System.out.println();
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    encriptarTextoConsola();
                    break;
                case "2":
                    encriptarArchivo();
                    break;
                case "3":
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }

        } while (!opcion.equals("3"));
    }

    private void encriptarTextoConsola() {
        System.out.print("Ingrese el texto a encriptar: ");
        String texto = entrada.nextLine();
        System.out.print("Ingrese la clave de encriptación: ");
        int clave = entrada.nextInt();
        entrada.nextLine(); // Consumir el salto de línea

        String textoEncriptado = Alfabeto.encriptarTexto(texto, clave);

        System.out.print("¿Desea guardar el texto encriptado? (sí/no): ");
        if (entrada.nextLine().equalsIgnoreCase("sí")) {
            String rutaSalida = adminArchivo.solicitarRutaGuardar();
            try {
                adminArchivo.escribirArchivo(rutaSalida, textoEncriptado);
                System.out.println("Texto encriptado guardado en " + rutaSalida);
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo: " + e.getMessage());
            }
        } else {
            System.out.println();
            System.out.println("Texto encriptado: " + textoEncriptado);
            System.out.println();
        }
    }

    private void encriptarArchivo() {
        String rutaArchivo = adminArchivo.solicitarRutaLectura();
        try {
            String texto = adminArchivo.leerArchivo(rutaArchivo);
            System.out.print("Ingrese la clave de encriptación: ");
            int clave = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

            String textoEncriptado = Alfabeto.encriptarTexto(texto, clave);

            System.out.print("¿Desea guardar el archivo encriptado? (sí/no): ");
            if (entrada.nextLine().equalsIgnoreCase("sí")) {
                String rutaSalida = adminArchivo.solicitarRutaGuardar();
                adminArchivo.escribirArchivo(rutaSalida, textoEncriptado);               //tuve problemas en como guardar el archivo :(
                System.out.println("Archivo encriptado guardado en " + rutaSalida);
            } else {
                System.out.println();
                System.out.println("Texto encriptado: " + textoEncriptado);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
