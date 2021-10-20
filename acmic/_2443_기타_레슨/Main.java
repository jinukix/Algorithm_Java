package _2443_기타_레슨;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int right = 0;
        int left = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        while (left <= right) {
            int mid = (left + right) /2;
            int sum = 0;
            int cnt = 1;

            for (int x : arr) {
                sum += x;

                if (mid < sum) {
                    cnt++;
                    sum = x;
                }
            }

            if (cnt <= m) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        bw.write(Integer.toString(left));
        bw.flush();
        bw.close();
        br.close();
    }
}
