package 나무_자르기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        while (start < end) {
            int mid = (start+end) / 2;

            long sum = 0;
            for (int tree: arr) {
                if (tree > mid) {
                    sum += (tree-mid);
                }
            }

            if (sum < m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(start-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
