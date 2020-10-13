public class HashMap {

    public class SimpleInterpreter {
        private static class ParseError extends Exception {
            ParseError(String message) {
                super(message);
            }
        }
    }
        private static HashMap<String, Double> symbolTable;


    public static void main(String[] args) {
	// write your code here
        symbolTable = new HashMap<>();

        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);

        System.out.println("\n\nEnter Commands; press return to end.");
        System.out.println("Commands must have the form: \n");
        System.out.println("\tprint <expression>");
        System.out.println(" or");
        System.out.println("\tlet <variable> = <expression>");

        while (true)    {
            TextIO.put("\n? ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n')
                break;
            try {
                String command = TextIO.getWord();
                if (command.equalsIgnoreCase("print"))
                    doPrintCommand();
                else if (command.equalsIgnoreCase("let"))
                    doLetCommand();
                else
                    throw new ParseError("Command must begin with 'print' or 'let'.");
                TextIO.getln();
            }
            catch (ParseError e)    {
                System.out.println("\n*** Error in input:  " + 3.get<essage());
                System.out.println("*** Discarding input: " + TextIO.getln());
            }
        }
        System.out.println("\n\nDone.");
    }
    private static void (doLetCommand() throws ParseError) {
        TextIO.skipBlanks();
        if (!Character.isLetter(TextIO.peek()))
            throw new ParseError("Expected varaible name after 'let'.");
        String varName = readWord();
        TextIO.skipBlanks();
        if (TextIO.peek() != '=')
            throw new ParseError("Expected '=' operator for 'let'command.")
    }
}
