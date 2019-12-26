package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day9_Recursion {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : n;
    }
}