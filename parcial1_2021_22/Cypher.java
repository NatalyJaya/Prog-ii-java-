package parcial1_2021_22;

import java.util.Arrays;

public class Cypher {
    private CharPair[] set;
    private int it;

    public Cypher(int initialSize){
        set = new CharPair[initialSize];
        it = 0;
    }

    public boolean addPair(char from, char to){
        CharPair cp = new CharPair(from,to);

        for (int i = 0; i < it; i++) {
            if(set[i].conflictsWith(cp)) return false;
        }

        resize();
        set[it] = cp;
        it++;

        return true;
    }

    public Cypher invert(){
        if(it == 0) return null;
        Cypher cp = new Cypher(it);

        for (int i = 0; i < it; i++) {
            cp.set[i] = this.set[i].invert();
        }
        return cp;
    }

    public String encode(String input){
        StringBuilder encMsg = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int c = checkChar(input.charAt(i)) ;
            if (!(c < 0)) encMsg.append((char) c);
            else return null;
        }

        return encMsg.toString();
    }

    private int checkChar(char c) {
        for (int i = 0; i < it; i++) {
            int cl = set[i].encode(c);

            if(!(cl < 0)) return cl;
        }
        return -1;
    }


    private void resize() {
        if(set.length <= it){
            CharPair[] aux = set;
            set = new CharPair[it*2];

            for (int i = 0; i < it; i++) set[i] = aux[i];
        }
    }

    @Override
    public String toString() {
        String s ="-------------\n";
        s = s.concat("|from --- to|\n");
        s = s.concat("|-----------|\n");

        for (int i = 0; i < it; i++) {
            s = s.concat(set[i].toString());
        }
        s = s.concat("-------------");
        s = s.concat("\nit = "+it+"\n");
        return s;
    }
}
