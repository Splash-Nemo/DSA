import java.util.*;
class shortDistance {
    public List<Integer> shortestDistanceAfterQueries(int n, List<int[]> queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distances = new int[n];
        Arrays.fill(distances, n - 1);

        for (int i = 1; i < n; i++) {
            graph.get(i).add(i - 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int[] query : queries) {
            int source = query[0], target = query[1];
            graph.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            updateDistances(graph, source, distances);
            answer.add(distances[0]);
        }

        return answer;
    }

    private void updateDistances(List<List<Integer>> graph, int current, int[] distances) {
        int newDist = distances[current] + 1;
        for (int neighbor : graph.get(current)) {
            if (distances[neighbor] <= newDist) continue;
            distances[neighbor] = newDist;
            updateDistances(graph, neighbor, distances);
        }
    }
}