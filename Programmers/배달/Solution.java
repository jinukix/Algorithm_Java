package 배달;

import java.util.*;

class Solution {
    static class Node {
        final int distance;
        final int now;

        Node(int distance, int now) {
            this.distance = distance;
            this.now = now;
        }
    }

    public int solution(int n, int[][] roads, int k) {
        HashMap<Integer, ArrayList<Integer[]>> map = new HashMap();
        for (int i = 1; i < n+1; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] road: roads) {
            int start = road[0];
            int end = road[1];
            int cost = road[2];
            map.get(start).add(new Integer[]{end, cost});
            map.get(end).add(new Integer[]{start, cost});
        }

        int[] distances = new int[n+1];
        Arrays.fill(distances, k+1);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(
                Comparator.comparingInt((Node node) -> node.distance)
        );

        int start = 1;
        priorityQueue.add(new Node(0, start));
        distances[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (distances[node.now] < node.distance) continue;

            for (Integer[] arr: map.get(node.now)) {
                int cost = node.distance + arr[1];
                int end = arr[0];

                if (cost < distances[end]) {
                    distances[end] = cost;
                    priorityQueue.add(new Node(cost, end));
                }
            }
        }

        return (int) Arrays.stream(distances).filter(i -> i<=k).count();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        sol.solution(5, road, 3);
    }
}