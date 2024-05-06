import acm.program.CommandLineProgram;

public class Problema23 extends CommandLineProgram{

        public String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        public void run() {
            String msg = readLine("Dame un mensaje: ");
            int d = readInt("Dame un numero: ");
//        String msg= "Hola que tal";
//        int d = 4;
            String encodeMsg = encodeCaesar(msg, d);
            println(encodeMsg);
            msg = encodeMsg;
            d = -d;
            String decodeMsg = encodeCaesar(msg, d);
            println(decodeMsg);

        }

        private String encodeCaesar(String msg, int d) {
            StringBuilder encodedMsg = new StringBuilder();

            for (int i = 0; i < msg.length(); i++){
                encodedMsg.append(
                        isLower(msg.charAt(i), d) != '\0' ?
                                isLower(msg.charAt(i), d) :
                                isUpper(msg.charAt(i), d) != '\0' ?
                                        isUpper(msg.charAt(i), d) :
                                        ' '
                );
            }
            return encodedMsg.toString();
        }

        private char isLower(char c, int d) {
            String chars = ALPHABET; // 27
            int originalD = d;

            for(int i = 0; i < chars.length(); i++){
                d = originalD;
                if(d>=0 &&( chars.length()-1 - i ) < d){ // en caso que sea positivo i la d supera a la diferencia de distancia entre i y el length
                    d = (d-1) - (chars.length() - 1 - i);
                }else if(d < 0 && (chars.length()-1)-((chars.length()-1)-i) < d*(-1)){  // un caso similar pero con negativos.
                    d += chars.length();
                }
                else{
                    d += i;
                }
                if(c == chars.charAt(i)){
                    return chars.charAt(d);
                }
            }
            return '\0';
        }

        public char isUpper(char c, int d){
            String chars = ALPHABET.toUpperCase();
            int originalD = d;

            for(int i = 0; i < chars.length(); i++){
                d = originalD;
                if(d>=0 &&( chars.length()-1 - i ) < d){
                    d = (d-1) - (chars.length() - 1 - i);
                }else if(d < 0 && (chars.length()-1)-((chars.length()-1)-i) < d*(-1)){
                    d = d+chars.length();
                }
                else{
                    d = i+d;
                }
                if(c == chars.charAt(i)){
                    return chars.charAt(d);
                }
            }
            return '\0';
        }

        public static void main(String[] args) {
            new Problema23().start(args);
        }

    }

