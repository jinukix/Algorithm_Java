package 모두_0으로_만들기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long[] arr = new long[a.length];
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
            sum += a[i];
        }

        if (sum!=0) return -1;

        ArrayList<Integer>[] lists = new ArrayList[a.length];
        boolean[] visited = new boolean[a.length];
        int[] indegree = new int[a.length];
        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            lists[start].add(end);
            lists[end].add(start);
            indegree[start]++;
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i].size()==1) {
                queue.add(i);
            }
        }

        while (queue.size() > 1) {
            int start = queue.poll();
            visited[start] = true;

            for (int edge:lists[start]) {
                if (visited[edge]) continue;

                if (--indegree[edge] == 1) {
                    queue.add(edge);
                }

                if (arr[start] != 0) {
                    arr[edge] += arr[start];
                    result += Math.abs(arr[start]);
                    arr[start] = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {-5,0,2,1,2}, new int[][] {{0,1},{3,4},{2,3},{0,3}}));
    }
}