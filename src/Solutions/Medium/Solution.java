package Solutions.Medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long, Long> occurrences = arr.stream().collect((Collectors.groupingBy(e -> e, Collectors.counting())));
        List<Long> keys = occurrences.keySet().stream().sorted().collect(Collectors.toList());
        if (r == 1) {
            long occurencesOfFirstElement = occurrences.get(arr.get(0));
            return (occurencesOfFirstElement * (occurencesOfFirstElement - 1) * (occurencesOfFirstElement - 2)) / 6;
        }

        for(int i= 0; i < keys.size() - 2; i++) {
            long result1 = keys.get(i) * r;
            long result2 = keys.get(i+1) * r;
            if (result1 == (keys.get(i+1)) && result2 == (keys.get(i+2))) {
                count+= occurrences.get(keys.get(i)) * occurrences.get(keys.get(i+1)) * occurrences.get(keys.get(i+2));
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
