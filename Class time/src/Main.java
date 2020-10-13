import java.util.*;
class TimeConverter {

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
//        String time24;
        char ch='n';
        do{
            String time;
            int hours = 0, minutes = 0;
            Scanner in = new Scanner(System.in);
            String[] temp;
            System.out.print("Enter time in 24-hour notation: ");
            time = in.nextLine();
            temp = time.split(":");
            hours = Integer.parseInt(temp[0]);
            minutes = Integer.parseInt(temp[1]);
//            System.out.println("Enter time in 24-hour notation:");
//            time24 = sc.next();
//            int hour;
//            int min;
//            try{
//                // converting input data into hours and minutes.
////                hour = Integer.parseInt(time24.substring(0,time24.indexOf(":")));
////                min = Integer.parseInt(time24.substring(time24.indexOf(":")+1,time24.length()));
//                //checking time is valid or not.
//                if(hour<0 || hour >23)
//                    throw new TimeFormatException();
//                else if(minute<0 || minute>59)
//                    throw new TimeFormatException();
//                else{
//                    // checking time is below 12 hours or not.
//                    if(hour<12)
//                    {
//                        if(minute<10)
//
//                            System.out.println(hour+":0"+minute+"AM\n");
//                        else
//                            System.out.println(hour+":"+minute+"AM\n");
//
//                    }
//                    else
//                    {
//                        if(minute<10)
//                            System.out.println(hour%12+":0"+minute+"PM\n");
//                        else
//                            System.out.println(hour%12+":"+minute+"PM\n");
//                    }
//                }
//            }
            try {
                char ampm;
                if (hours < 0 || hours > 23)
                    throw new TimeFormatException();
                else if (minutes < 0 || minutes > 59)
                    throw new TimeFormatException();
                else {
                    if (hours < 12)
                        ampm = 'A';
                    else {

                        ampm = 'P';
                        hours -= 12;

                    }
                    if (hours == 0)
                        hours = 12;
                    else {
                        System.out.printf("That is the same as %d:%02d %cM\n", hours, minutes, ampm);
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Time Format Error\nWould you like to try");
            }
            System.out.println("Again?(y/n)");
            ch = sc.next().charAt(0);
        }while(ch=='y');
    }
}
class TimeFormatException extends Exception{
    public String toString()
    {
        System.out.println("Time Format Error\nWould you like to try");
        return "Error";
    }
}

