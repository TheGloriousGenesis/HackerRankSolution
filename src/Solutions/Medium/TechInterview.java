package Solutions.Medium;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

//23280669285391
public class TechInterview {
    public static void main(String[] args){
        System.out.println("0".matches(".*\\d.*"));
        System.out.println(prioritizedOrders(1, asList("[helool]")));
    }


    private static List<String> prioritizedOrders(int numOrders, List<String> orderList) {
        List<String> primeOrders = new ArrayList<>();
        List<String> nonPrimeOrders = new ArrayList<>();
        for( String i: orderList) {
            String[] order = i.split(" ");
            if (order[1].matches(".*\\d.*")) {
                nonPrimeOrders.add(i);
            }
        }

        orderList.removeAll(nonPrimeOrders);
        primeOrders.addAll(orderList);
//        primeOrders.sort();
        orderList.sort(Comparator
                .comparing(s -> s.split(" ", 2)[1]));

        orderList.addAll(nonPrimeOrders);
        return orderList;
    }

    private static List<PairInt> optimalUtilization(int maxTravelDist,
                                     List<PairInt> forwardRouteList,
                                     List<PairInt> returnRouteList)
    {
        List<PairInt> lessThanMaxDistForward = forwardRouteList.stream()
                .filter(x -> x.second >= maxTravelDist)
                .collect(Collectors.toList());
        List<PairInt> lessThanMaxDistReturn = returnRouteList.stream()
                .filter(x -> x.second >= maxTravelDist)
                .collect(Collectors.toList());
        HashMap<Integer, List<PairInt>> sumOfForwardAndReturn = new HashMap<>();
        for (PairInt i: lessThanMaxDistForward) {
            for (PairInt j: lessThanMaxDistReturn) {
                int key = i.second + j.second;
                if (sumOfForwardAndReturn.containsKey(key)) {
                    sumOfForwardAndReturn.get(key).add(new PairInt(i.first, j.second));
                } else {
                    sumOfForwardAndReturn.put(key, new ArrayList<>());
                }
            }
        }
        Set<PairInt> optimizedFlights = new HashSet<>();
        for(Map.Entry<Integer, List<PairInt>> entry: sumOfForwardAndReturn.entrySet()) {
            int value = maxTravelDist - entry.getKey();
            if (sumOfForwardAndReturn.containsKey(value)) {
                optimizedFlights.addAll(entry.getValue());
                optimizedFlights.addAll(sumOfForwardAndReturn.get(value));
            }
        }
        if (optimizedFlights.isEmpty()) {
            int i = 0;
            while (maxTravelDist > 0) {
                Set<Integer> values = sumOfForwardAndReturn.keySet().stream().sorted().collect(Collectors.toSet());

            }
        }

        return new ArrayList<>(optimizedFlights);
    }

    static class PairInt {
        public int first, second;
        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
