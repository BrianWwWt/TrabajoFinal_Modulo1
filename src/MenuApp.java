import java.util.Scanner;

public class MenuApp {

    private String opcion;
    private final Encriptador encriptador = new Encriptador();
    private final Desencriptador desencriptador = new Desencriptador();

    public void EjecutableMenu() {
        Scanner entrada = new Scanner(System.in);

        do {
            imprimirMenu();

            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    encriptador.mostrarMenu();
                    break;
                case "2":
                    desencriptador.mostrarMenu();
                    break;
                case "3":
                    System.out.println("Gracias por visitar al rey Cesar\uD83D\uDF32. \n ¡Nos vemos luego!\n♜♞♝♚♛♝♞♜\n" +
                            "♟♟♟♟♟♟♟♟\n" +
                            "▓░▓░▓░▓░▓░▓░\n" +
                            "░▓░▓░▓░▓░▓░▓\n" +
                            "▓░▓░▓░▓░▓░▓░\n" +
                            "░▓░▓░▓░▓░▓░▓\n" +
                            "♙♙♙♙♙♙♙♙\n" +
                            "♖♘♗♔♕♗♘♖\n" );
                    System.out.println("-Rerun for restart the app-");
                    break;
                default:
                    mostrarOpcionInvalida();
            }

        } while (!opcion.equals("3"));
    }

    private void imprimirMenu() {
        System.out.println("||——————————————— \uD83D\uDF32 CESAR CRIPTER \uD83D\uDF32 ————————————————||");
        System.out.println("||            M e n ú  P r i n c i p a l             ||");
        System.out.println("||———————————————————————————————————————————————————||");
        System.out.println("1. Encriptador.");
        System.out.println("2. Desencriptador.");
        System.out.println("3. Salir de CesarCripter.");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

    private void mostrarOpcionInvalida() {
        System.out.println("Opción inválida. Por favor, elija una opción entre 1 y 3.");
        EspacioInvalidOpcion();
    }

    private void EspacioInvalidOpcion() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}
