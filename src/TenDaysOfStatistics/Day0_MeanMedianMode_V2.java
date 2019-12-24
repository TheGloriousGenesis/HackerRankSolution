package TenDaysOfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class Day0_MeanMedianMode_V2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] numbers = new int[n];
        for(int i=0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        mean(numbers);
        median(numbers);
        mode(numbers);
    }

    private static void mean(final int[] numbers) {
        double sum = 0;
        for (double i: numbers) {
            sum+=i;
        }
        System.out.printf("%.1f%n", sum/numbers.length);
    }

    private static void median(final int[] numbers) {
        Arrays.sort(numbers);
        int lowerValue = numbers[numbers.length/2];
        int higherValue = numbers[(numbers.length-1)/2];
        System.out.printf("%.1f%n", (lowerValue + higherValue)/2.0);
    }

    private static void mode(final int[] numbers) {
        int[] occurrences = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            occurrences[i] = contains(numbers[i], numbers);
        }
        int maxValue = max(occurrences);
        System.out.printf("%d%n", numbers[maxValue]);
    }

    private static int max( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest;
    }

    private static int contains(final int value, final int[] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            counter = value == numbers[i] ? counter + 1 : counter;
        }
        return counter;
    }
}
