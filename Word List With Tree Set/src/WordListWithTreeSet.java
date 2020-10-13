import java.util.TreeSet;

public class WordListWithTreeSet {

    public static void main(String[] args) {
        // write your code here
        System.out.print("Press return to begin.");
        TextIO.getln();

        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("NO input file selected. Exiting.");
                System.exit(1);
            }
            TreeSet<String> wordSet = new TreeSet<>();
            String word = readNextWord();
            while (word != null) {
                word = word.toLowerCase();
                wordSet.add(word);
                word = readNextWord();
            }
            System.out.println("Number of different words found in file:" + wordSet.size());
            System.out.println();
            if (wordSet.size() == 0) {
                System.out.println("No words found in file.");
                System.out.println("Exiting and saving data.");
                System.exit(0);
            }
            TextIO.writeUserSelectedFile();
            TextIO.putln(wordSet.size() + " words found in file:\n");
            for (String w : wordSet)
                TextIO.putln(" " + w);
            System.out.println("\n\nDone.\n\n");
        } catch (Exception e) {
            System.out.println("Sorry an error has occured.");
            System.out.println("Error Message: " + e.getMessage());
        }
        System.exit(0);
    }

    private static String readNextWord() {
        char ch = TextIO.peek();
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            TextIO.getAnyChar();
            ch = TextIO.peek();

            if (ch == TextIO.EOF)
                return null;
            String word = "";
            while (true) {
                word += TextIO.getAnyChar();
                ch = TextIO.peek();
                if (ch == '\'') {
                    TextIO.getAnyChar();
                    ch = TextIO.peek();
                    if (Character.isLetter(ch)) {
                        word += "\'" + TextIO.getAnyChar();
                        ch = TextIO.peek();
                    } else
                        break;
                }
                if (!Character.isLetter(ch))
                    break;
            }
            return word;
        }
        return null;
    }
}
