public class TSP {
    int[][] cost;
    public TSP(int[][] cost) {
        this.cost = cost;
    }

    //reformulating my backtracking idea
    //tsp algorithm will contain:
    // visited boolean array
    // call DFS
    // DFS will search all possible paths starting at node (city) 0 and return the minimumTour found:
    // 1) if I've hit N cities, then I know I'm done and can exit, return to the initial city 0
    // 2) else, I still have more to search
    // 3) visit[current city] = TRUE
    // 4) explore current city recursively
    // 5) we explore by result = MINIMUM(result, cities[current City][lastCity] + DFS())
    // 6) backtrack, visited[current City] = FALSE
    // 7) return answer
    //minTour = Math.min(minTour,

    static int tsp(int[][] cost) {
        int numCities = cost.length;
        boolean[] visited = new boolean[numCities];
        visited[0] = true; //visit the first city, arbitrary
        int lastCity = 0;
        //first city doesn't impact final answer because 1->2->3->1 cost == 2->3->1->2 cost.
        //int minimumCostTour = Integer.MAX_VALUE; WRONG
        //!!!
        // I shouldn't keep track of answer as a parameter, it needs to be a pass-by-value object in the current recursion frame
        // !!!!!
        int minimumTour = dfs(cost, visited, lastCity, numCities, 1);

        return minimumTour;
    }
    static int dfs(int[][] cost, boolean[] visited, int lastCity, int numCities, int totalCitiesVisited) {
        if (totalCitiesVisited == numCities) {
            return cost[lastCity][0]; //I got back to the first visited city aka city 0
        }
        int minimumCostTour = Integer.MAX_VALUE; //CORRECT
        for (int currCity = 1; currCity < numCities; currCity++) {
            if (visited[currCity] == false) {
                visited[currCity] = true;
                minimumCostTour = Math.min(minimumCostTour,
                        cost[lastCity][currCity] + dfs(cost, visited, currCity, numCities, totalCitiesVisited + 1));
                //totalCitiesVisited++ as the update breaks the program...
                //backtrack
                visited[currCity] = false;
            }
        }
        return minimumCostTour;
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
        assert minimumTravelCost == 80; //answer for tspDistances is 80
        System.out.println("min travel cost for tsp problem is : " + minimumTravelCost);
    }
}
