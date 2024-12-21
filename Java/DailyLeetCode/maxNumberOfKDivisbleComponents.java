class Solution {
    int components = 0;
    ArrayList<ArrayList<Integer>> adjList;
    boolean[] visited;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[n];
        for(int[] e: edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        long ans = dfs(0, values, k);
        return components;
    }

    long dfs(int i, int[] values, int k) {
        if(visited[i]) return 0;
        visited[i] = true;
        long valSum = values[i];
        for(int adjInd: adjList.get(i)) {
            valSum += dfs(adjInd, values, k);
        }
        if(valSum % k == 0) components++;
        return valSum;
    }
}