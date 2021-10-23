package _3079_입국심사;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long left = Integer.MAX_VALUE;
        long right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.min(arr[i], left);
            right = Math.max(arr[i], right);
        }

        right *= m;
        while (left <= right) {
            long mid = (left+right)/2;
            long cnt = 0;

            for (int i : arr) {
                cnt += (mid / i);
            }

            if (cnt >= m) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(left));
        bw.flush();
        bw.close();
        br.close();
    }
}