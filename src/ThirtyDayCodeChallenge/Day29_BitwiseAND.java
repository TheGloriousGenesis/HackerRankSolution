package ThirtyDayCodeChallenge;

import java.util.Scanner;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day29_BitwiseAND {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> maximumValue = new ArrayList<>();
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            System.out.println(bitwise(n,k));
        }

        scanner.close();
    }

    private static int bitwise(final int n, final int k) {
        int[] s = new int[n];
        for (int i=0; i < n; i++) {
            s[i] = i + 1;
        }
        int temp = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                temp =  (s[i] | s[j]) < k  && (s[i] | s[j]) > temp ?
                        (s[i] | s[j]) : temp;
            }
        }
        return temp;
    }
}
