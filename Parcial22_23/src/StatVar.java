/* StatVar.java
 * -----------------
 * This program displays "hello, world" on the
 * screen.
 * It is inspired by the first program in Brian
 * Kernighan and Dennis Ritchie's classic book,
 * The C Programming Language.
 */

import acm.program.CommandLineProgram;
import utils.PackUtils;

public class  StatVar extends CommandLineProgram {

    public class StatVar {
        public static final int SIZE = 4 + 4 + 8;
        private int count;
        private int sum;
        private long sumSquares;

        public StatVar() {
            this.count = 0;
            this.sum = 0;
            this.sumSquares = 0L;
        }

        public void addObservation(int value) {
            count++;
            sum += value;
            sumSquares += value * value;
        }

        public double mean() {
            return (double) sum / count;
        }

        public void pack(byte[] record, int offset) {
            //...

        }

        public static StatVar unpack(byte[] record, int offset) {

        }


        public static void main(String[] args) {
            new StatVar().start(args);
        }
    }
}


/*
   public Author readAuthor(long idAuthor) throws IOException {
       // throw new UnsupportedOperationException("paso 3");
        authors.seek(idAuthor * Author.SIZE);
        byte[] record = new byte[Author.SIZE];
        authors.read(record);
        return Author.fromBytes(record);
    }
       public long numAuthors() throws IOException {
       // throw new UnsupportedOperationException("paso 3");
    return (authors.length()-1) / Author.SIZE;
    }
 */