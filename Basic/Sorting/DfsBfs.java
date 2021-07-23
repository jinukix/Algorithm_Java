package Sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs {
    public static void main(String[] args) {
        boolean[] visited = new boolean[9];
        int [][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        Arrays.fill(visited, false);
        dfs(graph, 1, visited);

        System.out.println();

        Arrays.fill(visited, false);
        bfs(graph, 1, visited);
    }

    /*
    DFS 깊이 우선 탐색

    스택을 사용하는 것이 정석, 재귀함수로도 구현을 합니다.
    BFS보다는 조금 느리게 동작.
    */
    public static void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int point : graph[start]) {
            if (!visited[point]) dfs(graph, point, visited);
        }
    }
    /*
    BFS 넓이 우선 탐색

    큐를 사용하는 것이 정석,
    DFS보다는 조금 빠르게 동작.
    */
    public static void bfs(int[][] graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (queue.size() > 0) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int point: graph[start]) {
                if (!visited[point]) {
                    queue.add(point);
                    visited[point] = true;
                }
            }
        }
    }
}
