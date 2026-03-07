public class TSP {
    int[][] cost;
    public TSP(int[][] cost) {
        this.cost = cost;
    }
    static int tsp(int[][] cost) {
        int numCities = cost.length;
        boolean[] visited = new boolean[numCities];
        //dfs calculates the minimum cost needed to perform a tour
        // from city 0 to all other cities where we visit these cities
        // only once, then end at the initial city 0.
        visited[0] = true; //I visit city 0 first,
        int minCost = dfs(cost, visited, 0,1, numCities);
        return minCost;
    }
    static int dfs(int[][] cost, boolean[] visited, int lastCity, int count, int totalCities) {
        if (count == totalCities) {
            //visited all cities now, calculate the cost to from lastCity -> city 0
            return cost[lastCity][0];
        }
        int result = Integer.MAX_VALUE;
        for (int currCity = 1; currCity < totalCities; currCity++) {
            //NEED to check if we've visited this city before...
            if (visited[currCity] == false) {
                visited[currCity] = true;
                //Accrue the cost of leaving (the prev) lastCity to go to currCity
                //lastCity will now be currCity, count++
                result = Math.min(result, cost[lastCity][currCity] + dfs(cost, visited, currCity, count + 1, totalCities));
                visited[currCity] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //-1 or 0?
        int[][] tspDistances = {
                // City 0, City 1, City 2, City 3
                { 0, 10, 15, 20 }, // Costs from City 0
                { 10, 0, 35, 25 }, // Costs from City 1
                { 15, 35, 0, 30 }, // Costs from City 2
                { 20, 25, 30, 0 }  // Costs from City 3
        };
        int minimumTravelCost = tsp(tspDistances);
        System.out.println("min travel cost for tsp problem is : " + minimumTravelCost);
    }
}
