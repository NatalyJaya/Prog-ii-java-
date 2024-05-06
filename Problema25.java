import acm.program.CommandLineProgram;
import java.util.StringTokenizer;

//HACERLO CON BUILDER [UNION MEDIANTE .append]

public class Problema25 extends CommandLineProgram {

    public void run() { //[PASOS BASICOS DE UN VOID]
        String frase = readLine("Introduce palabra:"); //FRASE [DAME LOS DATOS]
        String resultAcro = makeAcronym(frase);//[PROCESO LOS DATOS]
        println(resultAcro); // [MUESTRO LOS DATOS]

    }

    public String makeAcronym(String frase) {
        String acronym = "";
        StringTokenizer palabra = new StringTokenizer(frase);


        while (palabra.hasMoreTokens()) {
            String actualPalabra = palabra.nextToken();

            if (check(actualPalabra)) { //se puede usar el isValid(actualPalabra)
                acronym += (actualPalabra.toUpperCase().charAt(0)+'.');
                //toUpperCase es estatico porque no hace falta que crea una nueva c pero en mayus sino que aplico la transformacion en la misma c
            }
        }


            return acronym.toString(); // .substring(0, acronym.length() - 1) //hubiera servido pa descartar el punto final

    }

    public boolean check(String actualPalabra) { //isValid
        String[] conectores = {"el", "la", "un", "una", "unos", "y", "o", "de"};

        for (int i = 0; i < conectores.length; i++) {
            if (actualPalabra.equalsIgnoreCase(conectores[i])) {
                return false; //[isVALID] return true?????'
            }
        }
        return true; //[isVALID] return false???????

    }

    public static void main(String[] args) {
        new Problema25().start(args);
    }
}

