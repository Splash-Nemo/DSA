// Hierholzer’s Algorithm
import java.util.*;
class Solution {
    static final LinkedList<Integer> emptyList = new LinkedList<>();

    private LinkedList<Integer> getEmptyList() {
        return emptyList;
    }

    Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> balance = new HashMap<>();

    public int[][] validArrangement(int[][] edges) {
        int totalEdges = edges.length;

        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            if (entry.getValue() < 0) {
                start = entry.getKey();
            } else if (entry.getValue() > 0) {
                end = entry.getKey();
            }
        }

        Deque<Integer> path = new LinkedList<>();

        if (start != Integer.MIN_VALUE) {
            addEdge(-1, start);
            addEdge(end, -1);
            totalEdges += 2;
            path.addLast(-1);
        } else {
            path.addLast(edges[0][0]);
        }

        int count = 0;

        while (count < totalEdges) {
            Integer next = getNextEdge(path.peekLast());
            if (next == null) {
                rotate(path);
            } else {
                count++;
                path.addLast(next);
            }
        }

        if (start != Integer.MIN_VALUE) {
            while (path.peekFirst() != -1) {
                rotate(path);
            }
            path.pollFirst();
            path.pollLast();
        }

        boolean first = true;
        int prev = Integer.MIN_VALUE;
        int idx = 0;

        while (!path.isEmpty()) {
            if (!first) {
                int[] pair = new int[2];
                pair[0] = prev;
                pair[1] = path.pollFirst();
                prev = pair[1];
                edges[idx] = pair;
                idx++;
            } else {
                prev = path.pollFirst();
                first = false;
            }
        }

        return edges;
    }

    private void addEdge(int from, int to) {
        LinkedList<Integer> list = graph.getOrDefault(from, new LinkedList<>());
        list.add(to);
        graph.put(from, list);

        balance.put(from, balance.getOrDefault(from, 0) - 1);
        balance.put(to, balance.getOrDefault(to, 0) + 1);
    }

    private Integer getNextEdge(int vertex) {
        LinkedList<Integer> list = graph.getOrDefault(vertex, getEmptyList());
        return list.isEmpty() ? null : list.pollLast();
    }

    private void rotate(Deque<Integer> path) {
        path.pollLast();
        path.addFirst(path.peekLast());
    }
}
