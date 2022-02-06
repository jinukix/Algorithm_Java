package _2109_순회강연;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        if (n > 1) {
            StringTokenizer st;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                arr[i] = new int[]{p, d};
            }

            Arrays.sort(arr, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            });

            int time = arr[0][1];
            int idx = 0;
            while (time != 0) {
                while (idx < n && arr[idx][1] >= time) {
                    pq.add(arr[idx][0]);
                    idx++;
                }

                if (pq.isEmpty() && idx < n) {
                    time = arr[idx][1];
                    pq.add(arr[idx][0]);
                    idx++;
                }

                if (!pq.isEmpty()) {
                    result += pq.poll();
                    time--;
                } else {
                    break;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
