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
        int minimumCost = dfs(cost, visited, 0, visitedCityCount, numCities);
        return minimumCost;
    }
    public int dfs(int[][] cost, boolean[] visited, int lastCity, int numVisitedCities, int totalCities) {
        if (numVisitedCities == totalCities) {
            //we've seen every city now, so just find cost to go from lastCity -> initialCity 0
            return cost[lastCity][0];
        }
        int minimumCostTour = Integer.MAX_VALUE;
        for (int currentCity = 1; currentCity < totalCities; currentCity++) {
            if (visited[currentCity] == false) {
                visited[currentCity] = true;
                //explore currentCity recursively
                //recursively search for the answer
                int dfs = dfs(cost, visited, currentCity, numVisitedCities + 1, totalCities);
                minimumCostTour =
                        Math.min(minimumCostTour,
                                cost[lastCity][currentCity] + dfs(cost, visited, currentCity, numVisitedCities + 1, totalCities));
            }
        }
        return minimumCostTour;
    }
}
