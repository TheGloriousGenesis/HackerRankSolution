package ThirtyDayCodeChallenge.Day18_QueuesAndStacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Last-In-First-Out = Stacks
// First-In-First-Out = Queues
public class QueuesAndStack {
    private Stack<Character> stack;
    private Queue<Character> queue;

    public QueuesAndStack() {
        this.stack = new Stack<>();
        this.queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a QueuesAndStack object:
        QueuesAndStack p = new QueuesAndStack();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

    private void pushCharacter(char c) {
        stack.push(c);
    }

    private void enqueueCharacter(char c) {
        queue.add(c);
    }

    private char popCharacter() {
        return stack.pop();
    }

    private char dequeueCharacter() {
        return queue.remove();
    }
}