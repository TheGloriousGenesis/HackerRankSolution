package ThirtyDayCodeChallenge;

import java.util.*;

public class Day10_BinaryNumber {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        binary(n);
    }

    private static void binary(int n) {
        int count = 0;
        int maxCount = 0;

        char[] binary = Integer.toBinaryString(n).toCharArray();

        for (char c : binary) {
            count = (c == '0') ? 0 : count + 1;
            if (count > maxCount) {
                maxCount = count;
            }
        }

//        while (n > 0) {
//            int remainder = n % 2;
//            n = n / 2;
//
//            if (remainder == 1) {
//                count++;
//                if (maxCount <= count) {
//                    maxCount = count;
//                }
//            } else {
//                count = 0;
//            }
//        }
        System.out.print(maxCount);
    }
}