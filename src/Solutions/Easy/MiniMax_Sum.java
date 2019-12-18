package Solutions.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMax_Sum {


    static void miniMaxSum(int[] arr) {
        Long min = 0L;
        Long max = 0L;
        List<Long> app = new ArrayList<>();

        for(int i=0; i < arr.length; i++) {
            app.add((long) arr[i]);
        }

        List<Long> sortedNumbers = app.stream().sorted().collect(Collectors.toList());

        for(int i=0; i < arr.length - 1; i++) {
            min += sortedNumbers.get(i);
        }

        for(int i=1; i < arr.length ; i++) {
            max += sortedNumbers.get(i);
        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {

        int[] values = new int[]{256741038, 623958417, 467905213, 714532089, 938071625};

        miniMaxSum(values);
    }
}
