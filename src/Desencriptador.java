import java.io.IOException;
import java.util.Scanner;

public class Desencriptador {

    private final AdminArchivo adminArchivo = new AdminArchivo();
    private final Scanner entrada = new Scanner(System.in);

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println();
            System.out.println("---- MENÚ DESENCRIPTADOR ----");
            System.out.println("1. Desencriptar texto en consola.");
            System.out.println("2. Desencriptar archivo de texto.");
            System.out.println("3. Regresar al menú principal.");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    desencriptarTextoConsola();
                    break;
                case "2":
                    desencriptarArchivo();
                    break;
                case "3":
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }

        } while (!opcion.equals("3"));
    }

    private void desencriptarTextoConsola() {
        System.out.print("Ingrese el texto a desencriptar: ");
        String texto = entrada.nextLine();
        System.out.print("Ingrese la clave de desencriptación (dejar en blanco para intentar todos los desplazamientos): ");
        String claveInput = entrada.nextLine();

        if (claveInput.isEmpty()) {
            intentarDesencriptarSinClave(texto);
        } else {
            int clave = Integer.parseInt(claveInput);
            String textoDesencriptado = Alfabeto.desencriptarTexto(texto, clave);
            System.out.print("¿Desea guardar el texto desencriptado? (sí/no): ");
            if (entrada.nextLine().equalsIgnoreCase("sí")) {
                String rutaSalida = adminArchivo.solicitarRutaGuardar();
                try {
                    adminArchivo.escribirArchivo(rutaSalida, textoDesencriptado);
                    System.out.println("Texto desencriptado guardado en " + rutaSalida);
                } catch (IOException e) {
                    System.out.println("Error al guardar el archivo: " + e.getMessage());
                }
            } else {
                System.out.println();
                System.out.println("Texto desencriptado: " + textoDesencriptado);
                System.out.println();
            }
        }
    }

    private void desencriptarArchivo() {
        String rutaArchivo = adminArchivo.solicitarRutaLectura();
        try {
            String texto = adminArchivo.leerArchivo(rutaArchivo);
            System.out.print("Ingrese la clave de desencriptación (dejar en blanco para intentar todos los desplazamientos): ");
            String claveInput = entrada.nextLine();

            if (claveInput.isEmpty()) {
                intentarDesencriptarSinClave(texto);
            } else {
                int clave = Integer.parseInt(claveInput);
                String textoDesencriptado = Alfabeto.desencriptarTexto(texto, clave);
                System.out.print("¿Desea guardar el archivo desencriptado? (sí/no): ");
                if (entrada.nextLine().equalsIgnoreCase("sí")) {
                    String rutaSalida = adminArchivo.solicitarRutaGuardar();
                    adminArchivo.escribirArchivo(rutaSalida, textoDesencriptado);
                    System.out.println("Archivo desencriptado guardado en " + rutaSalida);
                } else {
                    System.out.println();
                    System.out.println("Texto desencriptado: " + textoDesencriptado);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void intentarDesencriptarSinClave(String texto) {
        System.out.println("Intentando desencriptar con todas las posibles claves...");
        for (int i = 1; i < Alfabeto.obtenerLongitud(); i++) {
            String textoDesencriptado = Alfabeto.desencriptarTexto(texto, i);
            System.out.println("Clave " + i + ": " + textoDesencriptado);
        }
    }
}
