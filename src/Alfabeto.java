import java.util.List;

public class Alfabeto {

    private static final List<Character> CARACTERES = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ');

    public static int obtenerIndice(char caracter) {
        return CARACTERES.indexOf(Character.toLowerCase(caracter));
    }

    public static char obtenerCaracter(int indice) {
        return CARACTERES.get(indice);
    }

    public static int obtenerLongitud() {
        return CARACTERES.size();
    }

    public static String encriptarTexto(String texto, int clave) {
        return procesarTexto(texto, clave);
    }

    public static String desencriptarTexto(String texto, int clave) {
        return procesarTexto(texto, -clave);
    }

    private static String procesarTexto(String texto, int desplazamiento) {
        StringBuilder textoProcesado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracterActual = texto.charAt(i);
            int indiceActual = obtenerIndice(caracterActual);

            if (indiceActual != -1) {
                int indiceNuevo = (indiceActual + desplazamiento) % obtenerLongitud();
                if (indiceNuevo < 0) {
                    indiceNuevo += obtenerLongitud();
                }
                textoProcesado.append(obtenerCaracter(indiceNuevo));
            } else {
                textoProcesado.append(caracterActual);
            }
        }

        return textoProcesado.toString();
    }
}
