import java.util.Random;
import java.util.LinkedList;

/**
 * Clase Recibe
 *
 * Crea un hilo que procesa cadenas de texto para introducirlas al buffer. Extiende a Thread para crear un hilo.
 *
 * @author Josue Morales
 * @author Homero Gonzalez
 * @author Osmar Hernandez
 * @author Ricardo Trevizo
 * @version 1.0
 */
public class Recibe extends Thread{

    //Atributos
    //Buffer donde se obtienen las cadenas de texto.
    private LinkedList buffer;

    /**
     * Constructor con 1 parametro
     * @param buffer buffer donde se obtienen las cadenas de texto
     */
    public Recibe(LinkedList buffer){
        this.buffer = buffer;
    }

    /**
     * Método que imprime las cadenas de texto del usuario y su equivalente en morse.
     * En caso de haber en caso de que el buffer tenga mas de 0 elementos, imprimira
     * la cadena de texto y su equvalente en morse.
     * Despues, esperara entre 1 y 30 segundos, para sacar la siguiente cadena traducida,
     * en caso de haber.
     * @see Thread
     */
    @Override
    public void run() {
        String mensaje;
        while(true){
            if(buffer.size()!=0){
                mensaje = (String) buffer.removeFirst();
                System.out.println(mensaje + " = "+ toMorse(mensaje));
            }
            try{
                Random random = new Random();
                int i = random.nextInt(30)+1;
                sleep(1000 * i);
            }
            catch(Exception e){
                System.out.println("Error: "+ e.toString());
            }
        }
    }

    /**
     * Método que reemplaza los caracteres alfanumericos a su equivalente en morse.
     * @param mensaje mensaje del usuario que sera traducido a morse.
     * @return Cadena de texto traducida a morse en "." y "-".
     */
    public String toMorse(String mensaje){
        String morse = mensaje.toLowerCase();
        morse = morse.replaceAll("a", ".-");
        morse = morse.replaceAll("b", "-...");
        morse = morse.replaceAll("c", "-.-.");
        morse = morse.replaceAll("d", "-..");
        morse = morse.replaceAll("e", ".");
        morse = morse.replaceAll("f", "..-.");
        morse = morse.replaceAll("g", "--.");
        morse = morse.replaceAll("h", "....");
        morse = morse.replaceAll("i", "..");
        morse = morse.replaceAll("j", ".---");
        morse = morse.replaceAll("k", "-.-");
        morse = morse.replaceAll("l", ".-..");
        morse = morse.replaceAll("m", "--");
        morse = morse.replaceAll("n", "-.");
        morse = morse.replaceAll("o", "---");
        morse = morse.replaceAll("p", ".--.");
        morse = morse.replaceAll("q", "--.-");
        morse = morse.replaceAll("r", ".-.");
        morse = morse.replaceAll("s", "...");
        morse = morse.replaceAll("t", "-");
        morse = morse.replaceAll("u", "..-");
        morse = morse.replaceAll("v", "...-");
        morse = morse.replaceAll("w", ".--");
        morse = morse.replaceAll("x", "-..-");
        morse = morse.replaceAll("y", "-.--");
        morse = morse.replaceAll("z", "--..");
        morse = morse.replaceAll("0", "-----");
        morse = morse.replaceAll("1", ".----");
        morse = morse.replaceAll("2", "..---");
        morse = morse.replaceAll("3", "...--");
        morse = morse.replaceAll("4", "....-");
        morse = morse.replaceAll("5", ".....");
        morse = morse.replaceAll("6", "-....");
        morse = morse.replaceAll("7", "--...");
        morse = morse.replaceAll("8", "---..");
        morse = morse.replaceAll("9", "----.");
        return morse;
    }
}
