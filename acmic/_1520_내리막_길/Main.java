package _1520_내리막_길;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] board, dp;
    static int m;
    static int n;

    static int[][] dir = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static int dfs(int y, int x) {
        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if (0 > nx || nx >= n || 0 > ny || ny >= m || board[y][x] <= board[ny][nx]) {
                continue;
            }

            dp[y][x] += dfs(ny, nx);
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        dp = new int[m][n];

        for (int y = 0; y < m; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < n; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                dp[y][x] = -1;
            }
        }

        int result = dfs(0, 0);
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
