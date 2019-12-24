package TenDaysOfStatistics;

import java.util.Scanner;

public class Day0_WeightedMean {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] numbers = new int[n];
        for(int i=0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] weights = new int[n];
        for(int i=0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        scanner.close();
        weightedMean(n, numbers, weights);
    }

    private static void weightedMean(final int n, final int[] numbers, final int[] weights) {
        double upperFraction = 0;
        double lowerFraction = 0;
        for(int i=0; i<n; i++) {
            upperFraction = upperFraction + numbers[i] * weights[i];
            lowerFraction = lowerFraction + weights[i];
        }
        System.out.printf("%.1f%n", upperFraction/lowerFraction);
    }
}
