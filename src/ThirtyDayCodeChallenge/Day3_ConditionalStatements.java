package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day3_ConditionalStatements {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        if (N % 2 > 0 || (N % 2 == 0 && N>=6 && N<=20)) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    }
}
