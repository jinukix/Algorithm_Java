package _2251_물통;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Integer> result = new ArrayList<>();
        boolean[][][] visited = new boolean[a + 1][b + 1][c + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, c});
        while (!queue.isEmpty()) {
            int[] elem = queue.poll();

            int x = elem[0];
            int y = elem[1];
            int z = elem[2];

            if (visited[x][y][z]) {
                continue;
            }

            visited[x][y][z] = true;

            if (x == 0) {
                result.add(z);
            }

            if (x != 0) {
                // a -> b
                if (b < x + y) {
                    queue.add(new int[]{(x - (b - y)), b, z});
                } else {
                    queue.add(new int[]{0, x + y, z});
                }

                // a -> c
                if (c < x + z) {
                    queue.add(new int[]{(x - (c - z)), y, c});
                } else {
                    queue.add(new int[]{0, y, x + z});
                }
            }

            if (y != 0) {
                // b -> a
                if (a < x + y) {
                    queue.add(new int[]{a, (y - (a - x)), z});
                } else {
                    queue.add(new int[]{x + y, 0, z});
                }

                // b -> c
                if (c < y + z) {
                    queue.add(new int[]{x, (y - (c - z)), c});
                } else {
                    queue.add(new int[]{x, 0, y + z});
                }
            }

            if (z != 0) {
                // c -> a
                if (a < x + z) {
                    queue.add(new int[]{a, y, (z - (a - x))});
                } else {
                    queue.add(new int[]{x + z, y, 0});
                }

                // c -> b
                if (b < y + z) {
                    queue.add(new int[]{x, b, (z - (b - y))});
                } else {
                    queue.add(new int[]{x, y + z, 0});
                }
            }
        }

        Collections.sort(result);
        for (int n : result) {
            bw.write(n + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}