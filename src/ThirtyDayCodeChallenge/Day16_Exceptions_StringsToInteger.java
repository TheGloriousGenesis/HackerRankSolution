package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day16_Exceptions_StringsToInteger {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String S = in.next();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        in.close();

        try {
            int x = Integer.parseInt(S);
            System.out.println(x);
        } catch (Exception e) {
            System.out.println("Bad String");
        }
    }
}