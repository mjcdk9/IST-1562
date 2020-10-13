package midTerm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                HashMap<Integer, ArrayList<String>> students = new HashMap<>();
                String line;
                int studentID;
                String course;
                Scanner keyboard = new Scanner(System.in);

                System.out.println("Enter student ID followed by course number. Do not add a space between the\n"  +
                        " class name and number. enter one class per line and enter the Student ID on each line\n" +
                        "-1 to exit.\n" +
                        "Ex.:\n" +
                        "18161537 MTH1200\n" +
                        "18161537 HIST2562\n" +
                        "18161537 IST1561\n" +
                        "17395263 IST3333\n" +
                        "17395263 IST5889\n" +
                        "-1\n" +
                        "Enter Student ID and course number below");
                do {
                    line = keyboard.nextLine();
                    line = line.trim(); // remove any leading or trailing whitespace
                    if (!line.equals("-1")) {

                        String[] parsedString = line.split(" ");
                        studentID = Integer.parseInt(parsedString[0]); // the ID
                        course = parsedString[1];
                        //Add to arraylist if student ID has been seen already
                        if (students.containsKey(studentID)) {
                            students.get(studentID).add(course);
                        } else {
                            // Add arraylist for the first time to the map
                            ArrayList<String> courses = new ArrayList<>();
                            courses.add(course);
                            students.put(studentID, courses);
                        }
                    }
                } while (!line.equals("-1"));

                // Now iterate through the map and output the student ID and all courses
                // associated with the student
                System.out.println();
                for (Integer key : students.keySet())
                {
                    System.out.println("For student: " + key);
                    for (String cls : students.get(key)) {
                        System.out.print(cls + " ");
                    }
                    System.out.println();
                    System.out.println();
                }
            }
        }