package _2110_공유기_설치;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1];
        int result = 0;

        while (left <= right) {
            int mid = (left+right)/2;
            int start = arr[0];
            int cnt = 1;

            for (int i = 1; i < arr.length; i++) {
                if (mid > arr[i]-start) continue;

                start = arr[i];
                cnt++;
            }

            if (cnt >= c) {
                result = mid;
                left = mid +1;
            } else {
                right = mid -1;
            }
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
