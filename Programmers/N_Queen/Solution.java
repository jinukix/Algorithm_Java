package N_Queen;

import java.util.stream.IntStream;

public class Solution {

    int result = 0;
    int[] graph;

    public void dfs(int r, int n) {
        if (r == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            graph[r] = i;

            if (check(r)) {
                dfs(r + 1, n);
            }
        }
    }

    public boolean check(int r) {
        return IntStream.range(0, r).noneMatch(
            i -> graph[r] == graph[i] || Math.abs(r - i) == Math.abs(graph[r] - graph[i]));
    }

    public int solution(int n) {
        graph = new int[n];
        dfs(0, n);
        return result;
    }
}
