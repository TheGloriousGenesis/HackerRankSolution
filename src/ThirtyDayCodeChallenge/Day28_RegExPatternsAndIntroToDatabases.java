package ThirtyDayCodeChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28_RegExPatternsAndIntroToDatabases {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> names = new ArrayList<>();
        String patternFirstName = "^[a-z]+${1,20}";
        String patternEmail = "^[\\.a-z]{1,40}+@[gmail]+\\.[com]";
        Pattern pNames = Pattern.compile(patternFirstName);
        Pattern pEmail = Pattern.compile(patternEmail);
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            Matcher mNames = pNames.matcher(firstName);
            Matcher mEmail = pEmail.matcher(emailID);
            if (mEmail.find() && mNames.find()) {
                names.add(firstName);
            }
        }
        scanner.close();

        names.stream().sorted().forEach(System.out::println);
    }
}