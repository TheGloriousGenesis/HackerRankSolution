package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day11_2DArrays {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        for(int i = 0; i <6; i++) {
            for(int j = 0; j < 6; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        System.out.println(hourglass(matrix));

    }

    private static int hourglass(final int[][] arr) {
        int max = 0;
        for(int i = 0; i<4; i++) {
            for(int j = 0; j<4; j++) {
                int current = 0;
                for(int x = j; x < j + 3; x++){
                    current+= arr[i][x];
                    current+= arr[i+2][x];
                    current+= (x == j+1) ? arr[i + 1][j + 1] : 0;
                }
                max = (i == 0 && j == 0) ? current : max;
                max = current > max ? current : max;
            }
        }
        return max;
    }
}