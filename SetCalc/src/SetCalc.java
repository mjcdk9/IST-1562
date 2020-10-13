import java.util.TreeSet;

public class SetCalc {

    public static void main(String[] args) {
	// write your code here
        System.out.println("This program will compute union,intersection,");
        System.out.println("and set difference of sets of integers,\n\n" +
                "Enter set computations (press return to exit");

        while (true){
            char ch;
            System.out.print("\n ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n')
                break;
            try {
                calc();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error in input: "+ e.getMessage());
            }
            TextIO.getln();
        }
    }
    private static void calc() {
        TreeSet<Integer> A, B;
        char op;

        A = readSet();
        TextIO.skipBlanks();
        if (TextIO.peek() != '*' && TextIO.peek() != '+' && TextIO.peek() != '-')
            throw new IllegalArgumentException("Expected *, +, or - after first set.");
        op = TextIO.getAnyChar();

        B= readSet();
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n')
            throw new IllegalArgumentException("Extra Unexpected input.");

        if (op == '+')
            A.addAll(B);
        else if(op == '*')
            A.retainAll(B);
        else
            A.removeAll(B);

        System.out.print("Value : " + A);
    }

    private static TreeSet<Integer> readSet() {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TextIO.skipBlanks();
        if (TextIO.peek() != '[')
            throw new IllegalArgumentException("Expected '[' at start of set.");
                    TextIO.getAnyChar();

                    TextIO.skipBlanks();
                    if (TextIO.peek() == '}') {
                        TextIO.getAnyChar();
                        return set;
                    }
                    while (true) {
                        TextIO.skipBlanks();
                        if (!Character.isDigit(TextIO.peek()))
                            throw new IllegalArgumentException("Expected an integer.");
                        int n = TextIO.getInt();
                        set.add(Integer.valueOf(n));
                        TextIO.skipBlanks();
                        if (TextIO.peek() == ']')
                            break;
                        else if (TextIO.peek() == ',')
                            TextIO.getAnyChar();
                        else
                            throw new IllegalArgumentException("Expected ',' or ']' .");
                    }
                    TextIO.getAnyChar();
                    return set;
    }
}
