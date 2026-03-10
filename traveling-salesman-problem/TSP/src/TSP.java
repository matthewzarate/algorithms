public class TSP {
    public TSP() {
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
                int exploredPaths = dfs(cost, visited, currCity, numCities, totalCitiesVisited + 1);
                //passing recursive exploredPaths result into MIN(minimumCostTour, cost + exploredPaths);
                minimumCostTour = Math.min(minimumCostTour, cost[lastCity][currCity] + exploredPaths);
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
        int[][] matrix4x4 = {
                {0, 81, 49, 41},
                {81, 0, 83, 58},
                {49, 83, 0, 42},
                {41, 58, 42, 0}
        }; //total-distance 164

        int[][] matrix5x5 = {
                {0, 63, 45, 71, 47},
                {63, 0, 57, 60, 25},
                {45, 57, 0, 81, 65},
                {71, 60, 81, 0, 47},
                {47, 25, 65, 47, 0}
        };// total distance 188
        //WRONG it should be: (my code gets 245...) 245 seems right!!
        //        //0>2->1->4->3->0

        // 6x6 +more dimensional cases
        // ideal for testing the efficiency of
        // algorithms like Held-Karp or Branch and Bound.
        int[][] matrix6x6_A = {
                {0, 74, 52, 80, 57, 90},
                {74, 0, 39, 29, 48, 93},
                {52, 39, 0, 81, 53, 46},
                {80, 29, 81, 0, 41, 64},
                {57, 48, 53, 41, 0, 69},
                {90, 93, 46, 64, 69, 0}
        }; // total distance...52 (0 to 2) + 46 (2 to 5) +
                    // 64 (5 to 3) +
                    // + 29 (3 to 1) + 48 (1 to 4) + 57 (4 to 0)
                    //= 296
        int[][] matrix6x6_B = {
                {0, 56, 55, 59, 39, 70},
                {56, 0, 62, 53, 29, 72},
                {55, 62, 0, 48, 83, 33},
                {59, 53, 48, 0, 58, 30},
                {39, 29, 83, 58, 0, 57},
                {70, 72, 33, 30, 57, 0}
        }; //total distance 239
        //path 0 → 2 → 5 → 3 → 1 → 4 → 0
        // 55 (0 to 2) + 33 (2 to 5) + 30 (5 to 3) + 53 (3 to 1) +
        // +29 (1 to 4) + 39 (4 to 0) = 239
        //int minimumTravelCost = tsp(matrix6x6_B);
        //assert minimumTravelCost == 80; //answer for tspDistances is 80
        //System.out.println("min travel cost for tsp problem is : " + minimumTravelCost);
    }
}
