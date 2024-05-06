import  acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class problema24 extends CommandLineProgram {
    public void run() {
        String line = readLine("Introduce línea de texto:");
        println(longestWord(line));


    }
    // METODO SIN EL STRINGBUILDER [ EL METODO MAS EFICIENTE Y CON FACIL LECTURA EN EL OTRO NOS ENROLLAMOS]
    public String longestWord(String line) {
        StringTokenizer palabra = new StringTokenizer(line, ",.;: 1234567890");
        String PalabraLarga = ("");
        while (palabra.hasMoreTokens()) {
            String ActualPalabra = palabra.nextToken();

            if (PalabraLarga.length() < ActualPalabra.length()) {
                PalabraLarga = ActualPalabra;
            }
        }

          return PalabraLarga;


        }

    //CON EL METODO STRINGBUILDER (LO MISMO INUTIL == INECESARIO)
   /* public String longestWord(String line) {
        StringTokenizer palabra = new StringTokenizer(line, ",.;: 1234567890");
        StringBuilder PalabraLarga = new StringBuilder(); //para declarar el stringbuilder vacio no hace falta el ("")

        while (palabra.hasMoreTokens()) {
            String ActualPalabra = palabra.nextToken();

            if (PalabraLarga.length() < ActualPalabra.length()) {

                PalabraLarga = new StringBuilder(ActualPalabra);
            }
        }
        return PalabraLarga.toString(); //RETORNAMOS UN STRING ASI QUE PASAMOS EL BUILDER A STRING!!!
    }
*/

public static void main (String[] args) {
        new problema24().start(args);
}

}
//el null no existe a emmoria entonces no es bj receptor de long lenght entonces a parsar por el if cualquier cosa hasta como el vacio (espacio) es mejro que null asi que pase pero al final lo devuelve
// un string con = lo que haces es ver si apuntan al mismo objeto de memoria (datos de memoria?)
// en string para comparar si coinciden lo que tienen hay que usar la funcion equals
