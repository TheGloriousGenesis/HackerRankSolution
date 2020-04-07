package TenDaysOfStatistics;

import java.util.Scanner;
import java.util.TreeSet;

public class Day1_StandardDeviation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        int[] numbers = new int[n];
//        for(int i=0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        standardDeviation(n,numbers);
        primeFactors(2L);
    }

    private static void standardDeviation(final int n, final int[] numbers) {
        double mean = 0;
        for (double i: numbers) {
            mean+=i;
        }
        mean = mean/n;
        double squared_dis = 0;
        for(int x : numbers) {
            squared_dis += Math.pow((x - mean), 2);
        }
        squared_dis = squared_dis/n;
        System.out.printf("%.1f%n", Math.sqrt(squared_dis));
    }

    public static TreeSet<Long> primeFactors(final long number) {
        TreeSet<Long> primeFactors = new TreeSet<>();
        long copyOfNumber = number;
        for(long i=2L; i<= copyOfNumber; i++) {
            if (copyOfNumber % i == 0) {
                primeFactors.add(i);
                copyOfNumber /=i;
                i--;
            }
        }
        System.out.println("TreeSet values");
        primeFactors.forEach(x -> System.out.println(x));
        return primeFactors;
    }
}