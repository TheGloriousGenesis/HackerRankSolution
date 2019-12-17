package Solutions.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class TheStoryOfATree {
//    // different number of games 1<q<5
//    int q = 0;
//    // number of nodes 1<n<10^5
//    int n = 0;
//    // number of guesses 1< g <10^5
//    int g = 0;
//    // minimum score needed to win 1< k <10^5
//    int k = 0;
//

    // different number of games
    int q = 2;
    // number of nodes
    int n = 4;
    // number of guesses
    int g = 2;
    // minimum score needed to win
    int k = 2;

    int parent = 0;

    int child = 0;

    int[][] guess = new int[g][1];


    static String storyOfATree(int n, int[][] edges, int k, int[][] guesses) {

        float winPercentage = k/guesses.length <= 1 ? k/guesses.length : 0;
        int winCounter = 0;

        Map<Integer, List<Integer>> parentChildNodes = parentChildMap(edges);


        for(int i=0; i<guesses.length; i++){
            int childNode = guesses[i][1];
            int parentNodeGuess = guesses[i][0];
            int actualParentNode = findParent(childNode, parentChildNodes);

            if (actualParentNode == parentNodeGuess) {
                winCounter++;
            }
        }

        if (winCounter >= k) {

        }

        return "lo";
    }

    private static int findParent(int childNode, Map<Integer, List<Integer>> parentNodes) {
    return 0;
    }

    public static void main(String[] args) {
        int[][] testValues = {{1,2}, {1,3}, {3,4}};
        TheStoryOfATree.parentChildMap(testValues)
        .entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public static Map<Integer, List<Integer>> parentChildMap(final int[][] edges) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();

        for (int i =0;i< edges.length; i++) {
            if (parentChildMap.get(edges[i][0]) == null) {
                List<Integer> childNodes = new ArrayList<Integer>();
                childNodes.add(edges[i][1]);
                parentChildMap.put(edges[i][0], childNodes);
            } else {
                List<Integer> childNode = parentChildMap.get(edges[i][0]);
                childNode.add(edges[i][1]);
                parentChildMap.put(edges[i][0], childNode);
            }
        }
        return parentChildMap;
    }
}


