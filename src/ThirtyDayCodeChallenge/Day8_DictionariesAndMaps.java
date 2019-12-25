package ThirtyDayCodeChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day8_DictionariesAndMaps {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashMap<String, Integer> phonebook = new HashMap();
        for(int i = 0; i <n; i++) {
            phonebook.put(scanner.next(), scanner.nextInt());
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        List<String> queries = new ArrayList<>();
        while(scanner.hasNextLine()){
            String s = scanner.next();
            if (s.equals("exit")) {
                break;
            }
            queries.add(s);
        }
        scanner.close();
        findNames(phonebook, queries);
    }

    private static void findNames(HashMap<String, Integer> phonebook, List<String> queries) {
        queries.forEach(name -> {
            Integer number = phonebook.get(name);
            if (number == null) {
                System.out.println("Not found");
            } else {
                System.out.println(name + "=" + number);
            }
        });
    }


}