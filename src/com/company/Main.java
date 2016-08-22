import java.util.LinkedList;

/**
 * Clase Main
 *
 * Inicia el programa.
 *
 * @author Josue Morales
 * @author Homero Gonzalez
 * @author Osmar Hernandez
 * @author Ricardo Trevizo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        LinkedList buffer = new LinkedList();
        Manda manda = new Manda(buffer);
        Recibe recibe = new Recibe(buffer);
        manda.start();
        recibe.start();
    }
}
