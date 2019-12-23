package ThirtyDayCodeChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6_LetsReview {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<String> testCases = new ArrayList();
        while (n !=0){
            testCases.add(scanner.next());
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            n--;
        }
        scanner.close();
        for (String test: testCases) {
            char[] splitWord = test.toCharArray();
            String odd = "";
            String even = "";
            for (int i=0; i<splitWord.length; i++) {
                odd = i%2 == 0 ? odd + splitWord[i] : odd;
                even = i%2 != 0 ? even + splitWord[i] : even;
            }
            System.out.println(odd + " " + even);
        }
    }
}
