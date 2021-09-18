package 등굣길;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        for (int[] puddle:puddles) {
            board[puddle[1]-1][puddle[0]-1] = -1;
        }

        int num = 1;
        for (int i = 1; i < n; i++) {
            if (board[i][0] == -1) num = 0;
            board[i][0] = num;
        }

        num = 1;
        for (int i = 1; i < m; i++) {
            if (board[0][i] == -1) num = 0;
            board[0][i] = num;
        }

        for (int y = 1; y < n; y++) {
            for (int x = 1; x < m; x++) {
                if (board[y][x] == -1) {
                    board[y][x] = 0;
                    continue;
                }

                board[y][x] = (board[y-1][x] + board[y][x-1]) % 1_000_000_007;
            }
        }

        return board[n-1][m-1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(4,3, new int[][] {{2,2}});
    }
}