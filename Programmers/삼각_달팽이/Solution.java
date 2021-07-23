package 삼각_달팽이;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int y = -1;
        int x = 0;
        int cnt = 1;

        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                y += dy[i%3];
                x += dx[i%3];
                board[y][x] = cnt++;
            }
        }

        int[] result = new int[cnt-1];
        int idx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) break;
                result[idx++] = board[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(4)));
    }
}
