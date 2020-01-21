package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day26_NestedLogic {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] expected = new int[3];
        int[] actual = new int[3];
        for(int i=0; i<3; i++) {
            actual[i] = scanner.nextInt();
        }
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i=0; i<3; i++) {
            expected[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(fine(expected, actual));
    }

    private static int fine(int[] expected, int[] actual) {
        if (actual[2] > expected[2]) {
            return 10000;
        }
        if (actual[2] == expected[2]) {
            if (actual[1] > expected[1]) {
                return 500 * (actual[1] - expected[1]);
            }
            if (actual[1] == expected[1]) {
                if (actual[0] > expected[1]) {
                    return 15 * (actual[0] - expected[0]);
                }
                if (actual[0] == expected[0]) {
                    return 0;
                }
            }
        }
        return 0;
    }
}
