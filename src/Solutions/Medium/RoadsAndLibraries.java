package Solutions.Medium;

public class RoadsAndLibraries {
    public static void main(String[] args) {
       System.out.println(roadsAndLibraries(6, 2, 5,
               new int[][]{{1,3},{3,4},{2,4},{1,2},{2,3},{5,6}}));
       System.out.println(roadsAndLibraries(3, 2, 1,
               new int[][]{{1,2},{3,1},{2,3}}));
       System.out.println(roadsAndLibraries(5, 6, 1,
               new int[][]{{1,2},{1,3},{1,4}}));
       System.out.println(roadsAndLibraries(3, 2, 1,
               new int[][]{{1,2},{3,1},{2,3}}));
    }

    static long roadsAndLibraries(int n, long c_lib, long c_road, int[][] cities) {
        if (c_road > c_lib) {
            return c_lib * n;
        }
        boolean[] visited = new boolean[n];
        long[][] adjCities = new long[n][n];
        long librariesNeeded = 0;
        long[] roads = new long[1];
        for(int i=0; i < cities.length; i++) {
            int temp1 = cities[i][0] - 1;
            int temp2 = cities[i][1] - 1;
            adjCities[temp1][temp2] = 1;
            adjCities[temp2][temp1] = 1;
        }

        for (int i=0; i < cities[0].length; i++) {
            if (!visited[i]) {
                dfs(adjCities, visited, i, roads);
                librariesNeeded++;
            }
        }

        long numberOfUnconnectedCities = checkUnvisitedCity(visited);

        return c_road * roads[0] + (librariesNeeded + numberOfUnconnectedCities) * c_lib;
    }

    private static long checkUnvisitedCity(boolean[] visited) {
        long count = 0;
        for(boolean i: visited) {
            if (!i) {
                count++;
            }
        }
        return count;
    }

    private static void dfs(long[][] adjCities, boolean[] visited, int i, long[] roads) {
        visited[i] = true;
        for (int j = 0; j < adjCities[i].length; j++) {
            if (adjCities[i][j] == 1 && !visited[j]) {
                roads[0]++;
                dfs(adjCities, visited, j, roads);
            }
        }
    }
}
