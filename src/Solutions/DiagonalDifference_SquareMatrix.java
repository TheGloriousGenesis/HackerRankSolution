package Solutions;

import java.util.List;

import static java.util.Arrays.asList;

public class DiagonalDifference_SquareMatrix {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int matrixSize = arr.size();
        int leftToRight_diagonal = 0;
        int rightToLeft_diagonal = 0;
        int tab = matrixSize;
        for(int i=0; i<matrixSize; i++) {
            leftToRight_diagonal+= arr.get(i).get(i);
            rightToLeft_diagonal+= arr.get(i).get(tab-1);
            tab--;
        };
        return Math.abs(leftToRight_diagonal - rightToLeft_diagonal);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = asList(asList(11, 2, 4), asList(4, 5, 6), asList(10, 8, -12));

        Integer value = diagonalDifference(arr);
        System.out.println(value);
    }
}
