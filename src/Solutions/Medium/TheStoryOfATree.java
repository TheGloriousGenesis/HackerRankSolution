package Solutions.Medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TheStoryOfATree {
    static String storyOfATree(int n, int[][] edges, int k, int[][] guesses) {

        String winPercentage = "";

        Map<Integer, List<Integer>> parentChildNodes = nodeMap(edges);

        List<Integer> canWinIfRoot = findGuessMatch(k, guesses, parentChildNodes);

        if (canWinIfRoot.isEmpty()) {
            winPercentage = "0" + "/" + n;
        } else {
            winPercentage = canWinIfRoot.size() + "/" + n;
        }


        return winPercentage;
    }

    private static List<Integer> findGuessMatch(int k, int[][] guess, Map<Integer, List<Integer>> parentNodes) {
        List<Integer> winningRoots = new ArrayList<>();
        for(int i=0; i<guess.length; i++) {
            int parentNode = guess[i][0];
            int childNode = guess[i][1];

        }
        if (winningRoots.size() >= k) {
            return winningRoots;
        }
        Map<Integer, List<Integer>> cloneNodeMap = new HashMap<>();
        cloneNodeMap.putAll(parentNodes);

        parentNodes.entrySet().forEach(i ->{
            int root = i.getKey();
            List<Integer> childrens = i.getValue();
            List<Integer> parents = i.getValue();
            childrens.forEach(child -> {
                List<Integer> children = cloneNodeMap.get(child);
                if ((children != null && !children.isEmpty())) {
                    children.remove(root);
                }
                if (children.isEmpty()) {
                    parents.remove(child);
                }
            });
        });
        return winningRoots;
    }

    public static void main(String[] args) {
        int[][] testValues = {{1,2}, {1,3}, {3,4}};
        TheStoryOfATree.drawTree(4, testValues)
        .entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public static Map<Integer, List<Integer>> drawTree(final int root, int[][] edges){
        // returns map showing the parent to child mapping for a given root
        Map<Integer, List<Integer>> nodeMap = nodeMap(edges);
        Map<Integer, List<Integer>> cloneNodeMap = new HashMap<>(Map.copyOf(nodeMap));

        int[] distinctNodeValues = Arrays.stream(edges).flatMapToInt(Arrays::stream).distinct().toArray();
        List<Integer> orphanChildList = Arrays.stream(distinctNodeValues).boxed().collect(Collectors.toList());

        nodeMap.entrySet().forEach(k -> {
            List<Integer> allEdgesForNode = k.getValue();
            allEdgesForNode.remove(Integer.valueOf(root));
            cloneNodeMap.put(k.getKey(), allEdgesForNode);
        });

        int parentNode = root;
        return cloneNodeMap;
    }

    public static Map<Integer, List<Integer>> nodeMap(final int[][] edges) {
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

        for (int i =0;i< edges.length; i++) {
            if (parentChildMap.get(edges[i][1]) == null) {
                List<Integer> childNodes = new ArrayList<Integer>();
                childNodes.add(edges[i][0]);
                parentChildMap.put(edges[i][1], childNodes);
            } else {
                List<Integer> childNode = parentChildMap.get(edges[i][1]);
                childNode.add(edges[i][0]);
                parentChildMap.put(edges[i][1], childNode);
            }
        }
        return parentChildMap;
    }
}




