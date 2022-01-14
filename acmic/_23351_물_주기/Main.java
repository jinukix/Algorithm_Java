package _23351_물_주기;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Arrays.fill(arr, k);

        int result = 1;
        int start = 0;

        whileLoop:
        while (true) {
            for (int i = 0; i < a; i++) {
                arr[(start++) % n] += b;
            }

            start = start % n;
            for (int i = 0; i < n; i++) {
                if (--arr[i] == 0) {
                    break whileLoop;
                }
            }

            result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
