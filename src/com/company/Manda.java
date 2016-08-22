import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Manda
 *
 * Crea un hilo que procesa cadenas de texto para introducirlas al buffer. Extiende a Thread para crear hilo.
 *
 * @author Josue Morales
 * @author Homero Gonzalez
 * @author Osmar Hernandez
 * @author Ricardo Trevizo
 * @version 1.0
 */
public class Manda extends Thread{

    //Atributos
    //Buffer donde se introducen las cadenas de texto.
    private LinkedList buffer;
    //Regex para verificar que las cadenas de texto sean validad
    private final String regex = "[abcdefghijklmnopqrstuvwxyz0123456789]+";
    //pattern, parte de verificacion
    private Pattern pattern;
    //matcher, parte de verificacion
    private Matcher matcher;

    /**
     * Constructor con 1 parametro
     * @param buffer buffer donde se introducen las cadenas de texto
     */
    public Manda(LinkedList buffer){
        this.buffer = buffer;
        pattern = Pattern.compile(regex);
    }

    /**
     * Metodo que obtiene las cadenas de texto del usuario y las introduce a el buffer.
     * En caso de haber 10 elementos en el buffer, le pedira al usuario que espere 3 segundos
     * hasta que el buffer regrese a 9 elementos o menos.
     * En caso de que la cadena de texto sea "cantidad", mostrara la cantidad de elementos en
     * el buffer.
     * En caso de que la cadena de texto sea "off", terminara el programa.
     * Si llega a fallar el método sleep, imprira la causa  del error y el programa continuara
     * @see Thread
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String mensaje;
        System.out.println("Introduzca palabras cuando aparezca \"Mensaje:\" para traducir, " +
                        "\n\"cantidad\" para ver la cantidad del buffer u " +
                        "\n\"off\" para terminar el programa.");
        while(true){
            if(buffer.size()<10){
                System.out.println("Mensaje:");
                mensaje = scanner.nextLine();
                if(entradaValida(mensaje)){
                    if(!(mensaje.equals("off") || mensaje.equals("cantidad")))
                        buffer.add(mensaje);
                }
                else{
                    System.out.println("Caracter(es) no valido(s)");
                }
                if(mensaje.equals("off")) {
                    System.exit(0);
                }
                if(mensaje.equals("cantidad")) {
                    System.out.println("Cantidad buffer: "+buffer.size());
                }
            }
            else{
                try{
                    for(int i = 3; i>0; i--){
                        System.out.println("Buffer lleno, espere ("+(i)+")");
                        sleep(1000 * 1);
                    }
                }
                catch(Exception e){
                    System.out.println("Error: "+ e.toString());
                }
            }
        }
    }

    /**
     * Metodo que verifica que la cadena de texto sea valida
     * @param mensaje texto del usuario
     * @return <ul>
     *          <li>true: la cadena de texto contiene solo caracteres alfanumericos</li>
     *          <li>false: la cadena de texto tiene simbolos invalidos o está vacia</li>
     *          </ul>
     */
    public boolean entradaValida(String mensaje){
        matcher = pattern.matcher(mensaje);
        return mensaje.equals("")?false:matcher.matches();

    }
}
