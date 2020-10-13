import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Concordance {
    private static TreeMap<String, TreeSet<Integer>>  concordance;
    public static void main(String[] args) {
        System.out.println("\n\n   This program will ask you to select an input file.");
        System.out.println("It makes a list of all the words that occur in the file");
        System.out.println("along with the line number of each line that contained");
        System.out.println("that word.  This is called a \"concordance\" for the file.");
        System.out.println("\n   After reading the input file, the program asks you to");
        System.out.println("select an output file.  If you select a file, the list of");
        System.out.println("words will be written to that file; if you cancel, the list");
        System.out.println("be written to standard output.  All words are converted to");
        System.out.println("lower case.\n\n");
        System.out.print("Press return to begin.");

        TextIO.getln();

        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("No input file selected.  Exiting.");
                System.exit(0);
            }
            concordance = new TreeMap<String, TreeSet<Integer>>();
            int lineNum = 1;
            while (true) {
                char ch = TextIO.peek();
                while ( ch != TextIO.EOF && ! Character.isLetter(ch) ) {
                    TextIO.getAnyChar();
                    if (ch == '\n') {
                        lineNum++;
                    }
                    ch = TextIO.peek();
                }
                if (ch == TextIO.EOF) {
                    break;
                }
                String word = readWord();
                word = word.toLowerCase();
                if (word.length() > 2  && !word.equalsIgnoreCase("the")) {
                    addReference(word,lineNum);
                }
            }
            System.out.println(concordance.size() + " distinct words were found in the file.\n");
            System.out.println();
            if (concordance.size() == 0) {
                System.out.println("No words found in file.");
                System.out.println("Exiting without saving data.");
                System.exit(0);
            }
            TextIO.writeUserSelectedFile();
            printConcordance();
        }
        catch (IllegalArgumentException e) {
            System.out.println( "Sorry, some error occurred:  " + e.getMessage() );
        }
    }
    private static void printConcordance() {
        for ( Map.Entry<String, TreeSet<Integer>>  entry :  concordance.entrySet() ) {
            String term = entry.getKey();
            TreeSet<Integer> pageSet = entry.getValue();
            TextIO.put( term + " " );
            for ( int page : pageSet ) {
                TextIO.put( page + " " );
            }
            TextIO.putln();
        }
    }
    private static void addReference(String word, int lineNum) {
        TreeSet<Integer> references;
        references = concordance.get(word);
        if (references == null){
            TreeSet<Integer> firstRef = new TreeSet<Integer>();
            firstRef.add( lineNum );
            concordance.put(word,firstRef);
        }
        else {
            references.add( lineNum );
        }
    }
    private static String readWord() {
        char ch = TextIO.peek();
        assert Character.isLetter(ch);
        String word = "";
        while (true) {
            word += TextIO.getAnyChar();
            ch = TextIO.peek();
            if ( ch == '\'' ) {
                TextIO.getAnyChar();
                ch = TextIO.peek();
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();
                }
                else
                    break;
            }
            if ( ! Character.isLetter(ch) ) {
                break;
            }
        }
        return word;
    }
}