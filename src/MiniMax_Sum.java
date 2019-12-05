import java.util.Collections;

import static java.util.Arrays.asList;

public class MiniMax_Sum {


    static void miniMaxSum(int[] arr) {

        int min = 0;
        int max = 0;

        int[] sorted_max = new int[arr.length];

        int counter = 0;

        for(int i=0; i< arr.length-1; i++) {
            max = Math.max(arr[i], arr[i+1]);
            sorted_max[i] = Math.min(arr[i], arr[i+1]);
            if( max == arr[i]) {
                arr[i ] = 0;
            }
            min = Math.max(arr[i], arr[i+1]);
            counter++;
        }

        for (int i = 0; i < sorted_max.length; i++) {
            System.out.println(sorted_max[i]);
        }
        System.out.println(min + " " + max);

    }

    public static void main(String[] args) {

        int[] values = new int[]{5, 6, 1, 4, 5};


        miniMaxSum(values);
    }
}
