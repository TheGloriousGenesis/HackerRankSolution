package ThirtyDayCodeChallenge;

import java.util.Scanner;

import static ThirtyDayCodeChallenge.Day15_LinkedList.insert;

public class Day24_MoreLinkedLists {

    public static Day15_LinkedList.Node removeDuplicates(Day15_LinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Day15_LinkedList.Node x0 = head.next;
        if (head.data == x0.data) {
            head.next = x0.next;
            removeDuplicates(head);
        } else {
            removeDuplicates(x0);
        }
        return head;
    }



    public static void display(Day15_LinkedList.Node head)
    {
        Day15_LinkedList.Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Day15_LinkedList.Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}