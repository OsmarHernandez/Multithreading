import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Morales on 18/08/16.
 */
public class Manda extends Thread{

    LinkedList buffer;
    final String regex = "[abcdefghijklmnopqrstuvwxyz0123456789]+";
    Pattern pattern;
    Matcher matcher;

    public Manda(LinkedList buffer){
        this.buffer = buffer;
        pattern = Pattern.compile(regex);
    }

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

    public boolean entradaValida(String mensaje){
        matcher = pattern.matcher(mensaje);
        return mensaje.equals("")?false:matcher.matches();

    }
}
