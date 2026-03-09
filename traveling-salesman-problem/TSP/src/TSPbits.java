public class TSPbits {
    int[][] cost;

    /**bitmask approach to traveling salesman problem
     * helps reduce  space complexity**/
    public TSPbits(int[][] cost) {
        this.cost = cost;
    }
    public int tsp(int[][] cost) {
        int numCities = cost.length;
        int minimumCost = dfs(cost, 0, numCities);
        return minimumCost;
    }
    public int dfs(int[][] cost, int prevCity, int numCities) {
        return 5;
    }
}
