package TenDaysOfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class Day1_Quartiles {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] x = new int[n];
        for(int i=0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(x);
        quartiles(x);
    }

    public static void quartiles(final int[] x) {

        int[] q1_arr = Arrays.copyOfRange(x, 0, (x.length/2));
        int[] q3_arr = x.length % 2 == 0 ? Arrays.copyOfRange(x, (x.length/2), x.length) : Arrays.copyOfRange(x, (x.length/2) + 1, x.length);
        double median_q1 = (q1_arr[q1_arr.length/2] + q1_arr[(q1_arr.length-1)/2])/2.0;
        double median_q2 = (x[x.length/2] + x[(x.length-1)/2])/2.0;
        double median_q3 = (q3_arr[q3_arr.length/2] + q3_arr[(q3_arr.length-1)/2])/2.0;

        System.out.printf("%.0f%n", median_q1);
        System.out.printf("%.0f%n", median_q2);
        System.out.printf("%.0f%n", median_q3);
    }


}