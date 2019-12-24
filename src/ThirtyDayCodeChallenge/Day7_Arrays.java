package ThirtyDayCodeChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class Day7_Arrays {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] x = new int[n];
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++) {
            x[i] = scanner.nextInt();
        }
        scanner.close();
        reverse(n, x);
    }

    public static void reverse(int n, int[] values) {
        int[] reverseOrder = new int[n];
        n--;
        for(int i : values) {
            reverseOrder[n] = i;
            n--;
        }
        String reverse = Arrays.toString(reverseOrder)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
        System.out.println(reverse);
    }
}