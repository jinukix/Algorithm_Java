package _10870_피보나치수5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            bw.write(Integer.toString(0));
        } else if (n == 1 || n == 2) {
            bw.write(Integer.toString(1));
        } else {
            int[] dp = new int[n + 1];

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            bw.write(Integer.toString(dp[n]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}