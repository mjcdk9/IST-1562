import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMapExample {
    public static void main(String args[]){
        HashMap<Integer, ArrayList<String>> students = new HashMap<>();
        System.out.println("Enter student ID and class, -1 to stop: ");
        String className;
        int id;
        Scanner scanner = new Scanner(System.in);
        while (true){
            id = scanner.nextInt();
            if(id == -1){
                break;
            }
            className = scanner.next();
            if(!students.containsKey(id)) {
                ArrayList<String> temp = new ArrayList<String>() ;
                temp.add(className);
                students.put(id, temp);
            }
            else {
                ArrayList<String> temp = students.get(id);
                temp.add(className);
                students.put(id, temp);
            }
        }
        System.out.println("Student enrollment report: ");
        for (Map.Entry entry : students.entrySet()) {
            System.out.print(entry.getKey() + " ");
            ArrayList<String> classNames = (ArrayList<String>) entry.getValue();
            for(int i = 0;i< classNames.size();i++){
                System.out.print(classNames.get(i) + " ");
            }
            System.out.println();
        }
    }
}