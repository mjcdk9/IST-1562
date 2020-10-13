import java.util.*;
public class timeConvert {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {

            String time;
            int hours, minutes;
//            Scanner in = new Scanner(System.in);
            String[] temp;
            System.out.print("Enter time in 24-hour notation: ");
            time = in.nextLine();
            temp = time.split(":");
            hours = Integer.parseInt(temp[0]);
            minutes = Integer.parseInt(temp[1]);
            char ampm;
            try {
                if (hours < 0 || hours > 23)
                    throw new TimeFormatException();
                else if (minutes < 0 || minutes > 59)
                    throw new TimeFormatException();

                    if (hours < 12)
                        ampm = 'A';
                    else {
                        ampm = 'P';
                        hours -= 12;
                    }
                        System.out.printf("That is the same as %d:%02d %cM\n", hours, minutes, ampm);

            } catch (Exception e) {
//                    throw new TimeFormatException("There is no such time");
                System.out.printf("There is no such time as %d:%02d\n", hours, minutes);
            }
            System.out.print("Again? (y/n) ");
        } while (Character.toUpperCase(in.nextLine().charAt(0)) == 'Y');
    }
}
class TimeFormatException extends Exception{
    public String toString()
    {
        System.out.println("Time Format Error\nWould you like to try");
        return "Error";
    }
}

