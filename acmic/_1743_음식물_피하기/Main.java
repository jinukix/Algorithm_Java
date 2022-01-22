package _1743_음식물_피하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(int[][] arr, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 1;
        queue.add(new int[]{y, x});
        arr[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] start = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = start[0] + dir[i][0];
                int nx = start[1] + dir[i][1];

                if (0 <= ny && ny < arr.length && 0 <= nx && nx < arr[0].length
                    && arr[ny][nx] == 1) {
                    cnt++;
                    arr[ny][nx] = 0;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r - 1][c - 1] = 1;
        }

        int result = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (arr[y][x] == 1) {
                    result = Math.max(bfs(arr, y, x), result);
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}