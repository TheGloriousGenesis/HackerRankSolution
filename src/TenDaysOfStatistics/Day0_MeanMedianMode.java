package TenDaysOfStatistics;

import java.util.*;
import java.util.stream.Collectors;

public class Day0_MeanMedianMode {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<Integer> numberArray = new ArrayList<>();
        if (scanner.hasNext()) {
            String numbers = scanner.nextLine().trim();
            numberArray = Arrays.stream(numbers.split(" "))
                    .map(Integer::parseInt).sorted().collect(Collectors.toList());
        }
        scanner.close();
        mean(numberArray);
        median(numberArray);
        mode(numberArray);
    }

    public static void mean(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return;
        }
        double mean = 0;
        for(Integer i: numbers) {
           mean =  mean + i;
        }
        System.out.printf("%.1f%n", (mean/numbers.size()));
    }

    public static void median(final List<Integer> numbers) {
        Double middleLower = Math.floor(numbers.size() / 2.0);
        Double middleHigher = Math.ceil(numbers.size() / 2.0);
        if (middleLower.equals(middleHigher)) {
            middleLower--;
        }
        System.out.printf("%.1f%n",
                ((numbers.get(middleLower.intValue()) +
                        numbers.get(middleHigher.intValue())) / 2.0));

    }

    public static void mode(final List<Integer> numbers) {
        Map<Integer, Long> occurrences = numbers.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        long highestOccurrences = 0;
        List<Integer> indexOfHO = new ArrayList<>();

        for(Map.Entry<Integer, Long> entry: occurrences.entrySet()) {
            if (entry.getValue() == highestOccurrences) {
                indexOfHO.add(entry.getKey());
            } else if (entry.getValue() > highestOccurrences) {
                indexOfHO.clear();
                highestOccurrences = entry.getValue();
                indexOfHO.add(entry.getKey());
            }
        }

        List<Integer> modeNumbers = indexOfHO.stream().sorted().collect(Collectors.toList());
        System.out.printf("%d%n", modeNumbers.get(0));
    }
}
