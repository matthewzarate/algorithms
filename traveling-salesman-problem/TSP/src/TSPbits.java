public class TSPbits {

    /**
     * bitmask approach to traveling salesman problem
     * helps reduce  space complexity
     **/
    public TSPbits() {
    }
}


/** public static int tsp(int[][] cost) {
 int numCities = cost.length;
 boolean[] visited = new boolean[numCities];
 visited[0] = true;

 //Using bitmask integer to keep track of list of visited cities
 int mask = 1;
 int cityPosition = 0;
 int minimumCost = dfs(cost, mask, cityPosition, numCities);
 return minimumCost;
 }
 public static int dfs(int[][] cost, int bitMask, int lastCity, int totalCities) {
 //if bitMask contains all 1's except the current lastCity position
 if (bitMask <<  == totalCities) {
 //we've seen every city now, so just find cost to go from lastCity -> initialCity 0
 return cost[lastCity][0];
 }
 int minimumCostTour = Integer.MAX_VALUE;
 for (int currentCity = 1; currentCity < totalCities; currentCity++) {
 //if bitMask currentCity position == 0;
 if (visited[currentCity] == false) {
 //update bitMask currentCity position == 1;
 visited[currentCity] = true;
 //explore currentCity recursively
 //recursively search for the answer

 minimumCostTour = Math.min(minimumCostTour, cost[lastCity][currentCity] + dfs(cost, bitMask, currentCity, totalCities));
 visited[currentCity] = false;
 //for backtrack, there is no need to adjust bitwise value because pass-by-value,
 // not reference as in the backtracking visited array approachx
 }
 }
 return minimumCostTour;
 }
 }
 /*
 *
 */
