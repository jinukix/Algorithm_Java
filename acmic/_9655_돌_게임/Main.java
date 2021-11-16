package _9655_돌_게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!dp[i - 1]) {
                dp[i] = true;
            } else if (i >= 3 && !dp[i - 3]) {
                dp[i] = true;
            }
        }

        if (dp[n]) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}