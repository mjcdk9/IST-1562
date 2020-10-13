import textio.TextIO;
public class TestPhoneDirectoryWithTreeMap {

   public static void main(String[] args) {
       
	   PhoneDirectoryWithTreeMap directory = new PhoneDirectoryWithTreeMap();
       
       String name;
       String number;
       int menuOption;
       
       exitCase:do{
    	   System.out.println("\nPHONE DIRECTORY");
           System.out.println("1.  Add a name and number");
           System.out.println("2.  Display numbers");
           System.out.println("3.  Exit program");
           System.out.println("Please choose an option:");
           menuOption = TextIO.getlnInt();
           switch (menuOption){
              case 1:
            	  System.out.println("\nPlease enter the name you want to add to the phonebook:");
            	  name = TextIO.getlnString();
            	  System.out.println("Please enter the number you want to add to the phonebook:");
            	  number = TextIO.getlnString();
            	  directory.putNumber(name, number);
            	  break;
              case 2:
            	  System.out.println("\nContents are:");
            	  directory.print();
            	  System.out.println();
            	  break;
              case 3:
            	  break exitCase;
              default:
            	  System.out.println("\nPlease enter an option as shown in the menu.");
    	   }
       }while (menuOption != 3);
       System.out.println("\nGoodbye!");
   }

}