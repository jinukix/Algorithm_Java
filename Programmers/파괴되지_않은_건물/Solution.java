package 파괴되지_않은_건물;

import java.util.Arrays;

class Solution {

    public int solution(int[][] board, int[][] skill) {
        int result = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] prefixArr = new int[n + 1][m + 1];

        for (int[] row : skill) {
            int type = row[0];
            int degree = type == 1 ? -row[5] : row[5];
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];

            for (int i = r1; i <= r2; ++i) {
                prefixArr[i][c1] += degree;
                prefixArr[i][c2 + 1] += -degree;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j != 0) {
                    prefixArr[i][j] += prefixArr[i][j - 1];
                }
                board[i][j] += prefixArr[i][j];
                if (board[i][j] > 0) {
                    result++;
                }
            }
        }

        System.out.println(Arrays.deepToString(board));

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
            new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
            new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2},
                {1, 0, 1, 3, 3, 1}}));
    }
}