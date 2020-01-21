package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day25_RunningTimeAndComplexity {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(isPrime(scanner.nextInt()) ? "Prime" : "Not prime");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        scanner.close();
    }

    private static boolean isPrime(int n)
    {
        if ((n & 1) == 0)
        {
            return n == 2;
        }

        for (int i = 3; (i * i) <= n; i += 2)
        {
            if ((n % i) == 0)
            {
                return false;
            }
        }

        return n != 1;
    }
}