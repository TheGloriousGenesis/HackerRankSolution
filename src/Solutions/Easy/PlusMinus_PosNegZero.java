package Solutions.Easy;

import java.text.DecimalFormat;

public class PlusMinus_PosNegZero {

    static void plusMinus(int[] arr) {

        float n = arr.length;
        float positive = 0f;
        float negative = 0f;
        float zero = 0f;

        for (int i : arr) {
            if (i < 0) {
                negative++;
            } else if (i > 0) {
                positive++;
            } else {
                zero++;
            }
        }

        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format(positive/n));
        System.out.println(df.format(negative/n));
        System.out.println(df.format(zero/n));
    }

    public static void main(String[] args) {

        int[] values = new int[]{1, 2, -3, 3, 0};
        plusMinus(values);
    }
}
