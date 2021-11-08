package _1654_랜선_자르기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long left = 1;
        long right = 0;
        long mid = 0;

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }

        while (left <= right) {
            mid = (left + right) / 2;

            long cnt = 0;
            for (int x : arr) {
                cnt += (x / mid);
            }

            if (cnt < n) {
                right = mid - 1;
            } else if (cnt >= n) {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(right));
        bw.flush();
        bw.close();
        br.close();
    }
}
