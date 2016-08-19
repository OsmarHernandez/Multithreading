/*
* Equipo:
* Josue Morales
* Homero Gonzalez
* Osmar Hernandez
* Ricardo Trevizo
* */
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList buffer = new LinkedList();
        Manda manda = new Manda(buffer);
        Recibe recibe = new Recibe(buffer);
        manda.start();
        recibe.start();
    }
}
