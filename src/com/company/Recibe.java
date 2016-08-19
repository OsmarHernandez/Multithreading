import java.util.Random;
import java.util.LinkedList;

/**
 * Created by Morales on 18/08/16.
 */
public class Recibe extends Thread{

    LinkedList buffer;

    public Recibe(LinkedList buffer){
        this.buffer = buffer;
    }

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
