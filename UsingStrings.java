import acm.program.ConsoleProgram;

public class UsingStrings extends ConsoleProgram {
/*
    public boolean isVocal(char c) {
        String vocals = "AEIOUaeiou";
        char[] vocalsChars = vocals.toCharArray();
        int i = 0;
        while (i < vocalsChars.length && vocalsChars[i] != c) {
            i += 1;
        }
        return i < vocalsChars.length;
    }

    public String removeVocals(String str) {
        char[] resultChars = new char[str.length()];
        int resultLength = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (!isVocal(current)) {
                resultChars[resultLength] = current;
                resultLength += 1;
            }
        }
        return new String(resultChars, 0, resultLength);
    }

    public void run() {
        String sentence = readLine("Enter a sentence: ");
        String result = removeVocals(sentence);
        println("The sentence w/o vocals is: " + result);
        return null;
    }


 */
    public static void main(String[] args) {
        new UsingStrings().start(args);
    }
}
