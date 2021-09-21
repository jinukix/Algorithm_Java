package _1789_수들의_합;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        OutputStreamWriter outputStreamReader = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(outputStreamReader);

        long n = Long.parseLong(br.readLine());

        long target = n;
        int result = 0;
        for (long i = 1; i <= n; i++) {
            if (target < n) break;
            target-=i;
            result++;
        }

        bw.write(Integer.toString(result-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
