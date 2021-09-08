package 가장_먼_노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] ints : edge) {
            int start = ints[0];
            int end = ints[1];

            graph[start].add(end);
            graph[end].add(start);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int qSize = 1;

        while (!queue.isEmpty()) {
            qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                int temp = queue.poll();

                for (int eg : graph[temp]) {
                    if (!visited[eg]) {
                        visited[eg] = true;
                        queue.add(eg);
                    }
                }
            }
        }

        return qSize;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6, new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}} ));
    }
}