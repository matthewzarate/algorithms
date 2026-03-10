public class TSPbits {
    int[][] cost;

    /**bitmask approach to traveling salesman problem
     * helps reduce  space complexity**/
    public TSPbits(int[][] cost) {
        this.cost = cost;
    }
    public int tsp(int[][] cost) {
        int numCities = cost.length;
        boolean[] visited = new boolean[numCities];
        visited[0] = true;

        int visitedCityCount = 1;
        int minimumCost = dfs(cost, 0, visitedCityCount);
        return minimumCost;
    }
    public int dfs(int[][] cost, int lastCity, int numVisitedCities) {
        if (numVisitedCities == cost.length) {
            //we've seen every city now, find cost to go from lastCity -> initialCity 0
            return cost[lastCity][0];
        }
        else {
            int minimumCostTour = Integer.MAX_VALUE;

        }

    }
}
