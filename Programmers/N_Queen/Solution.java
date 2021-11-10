package N_Queen;

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
        for (int i = 0; i < r; i++) {
            if (graph[r] == graph[i] || Math.abs(r - i) == Math.abs(graph[r] - graph[i])) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n) {
        graph = new int[n];
        dfs(0, n);
        return result;
    }
}
