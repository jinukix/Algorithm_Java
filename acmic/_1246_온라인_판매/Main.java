package _1246_온라인_판매;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int pr = 0;
        for (int i = 0; i < m; i++) {

            int sum = 0;
            if (m - i < n) {
                sum = arr[i] * (m - i);
            } else {
                sum = arr[i] * n;
            }

            if (max < sum) {
                max = sum;
                pr = arr[i];
            }
        }

        bw.write(pr + " " + max);
        bw.flush();
        bw.close();
        br.close();
    }
}