public class ReverseList {

    static class ListNode{
        int item;
        ListNode next;
    }
    static ListNode reverse(ListNode list) {
        ListNode rev = null;
        ListNode runner = list;
        while (runner != null)  {
            ListNode newNode = new ListNode();
            newNode.item = runner.item;
            newNode.next = rev;
            rev = newNode;
            runner = runner.next;
        }
        return rev;
    }
    static  void printList(ListNode start)  {
        ListNode runner;
        runner = start;
        System.out.print("(");
        while (runner != null)  {
            System.out.print(" " + runner.item);
            runner = runner.next;
        }
        System.out.print(" )");
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println("I will print out a list and its reverse, for");
        System.out.println("several different lists. The first list is empty.\n");

        ListNode list = null;
        ListNode reversedList;

        int ct = 0;

        while (true)    {
            System.out.print("The list:        ");
            printList(list);
            System.out.println();
            reversedList = reverse(list);
            printList(reversedList);
            System.out.println("\n\n");
            ct++;
            if (ct == 999999999)
                break;
            ListNode head = new ListNode();
            head.item = (int)(Math.random()*100);
            head.next = list;
            list = head;
        }
    }
}
