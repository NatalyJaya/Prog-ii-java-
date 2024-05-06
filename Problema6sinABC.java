import acm.program.ConsoleProgram;
import java.util.StringTokenizer;

//PROBLEMA CON l amuestro de int con caracteres (no era asi)
public class Problema6sinABC extends ConsoleProgram {
   /* public void run() {
        String prompt = readLine("Introduce un numero, con signo : ");
        println(myReadInt(prompt));
    }

    public int myReadInt(String prompt) {
        StringBuilder numRes = new StringBuilder();

        // PUESTA DEL SIGNO
        char[] fraseChar = prompt.toCharArray();
        String signo = String.valueOf(fraseChar[0]);

        numRes = numRes.append(signo);

        StringTokenizer digit = new StringTokenizer(prompt.substring(1),  );
        while (digit.hasMoreTokens()) {
            String actualDigit = digit.nextToken();
            if (isDigit(actualDigit)) {
                numRes.append(actualDigit);
            }
        }

        return Integer.parseInt(numRes.toString());
    }

    public boolean isDigit(String actualDigit) {
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7","8", "9"};

        for (int i = 0; i < numeros.length; i++) {
            if (actualDigit.equals(numeros[i])) {
                return false;
            }
        }
        return true;


    }
    public static void main (String[] args) {
        new Problema6sinABC().start(args);
    }*/
}