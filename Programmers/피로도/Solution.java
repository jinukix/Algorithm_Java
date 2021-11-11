package 피로도;

class Solution {

    private int result = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0, 0);
        return result;
    }

    public void dfs(int[][] dungeons, boolean[] visited, int k, int depth, int count) {
        if (depth >= dungeons.length) {
            result = Math.max(count, result);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (dungeons[i][0] <= k) {
                    dfs(dungeons, visited, k - dungeons[i][1], depth + 1, count + 1);
                } else {
                    dfs(dungeons, visited, k, depth + 1, count);
                }

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}