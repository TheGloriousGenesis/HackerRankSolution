package Solutions.Easy;

import java.util.Arrays;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] ar) {
        int max = Arrays.stream(ar).max().getAsInt();

        long numberOfCandles = Arrays.stream(ar).filter(current -> current == max).count();

        return (int) numberOfCandles;
    }

    public static void main(String[] args) {

        int[] values = new int[]{5, 5, 5, 3, 2};

        birthdayCakeCandles(values);
    }
}
