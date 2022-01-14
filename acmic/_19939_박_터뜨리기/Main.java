package _19939_박_터뜨리기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= k; i++) {
            n -= i;
        }

        if (n < 0) {
            bw.write(-1 + "");
        } else if (n % k == 0) {
            bw.write(k - 1 + "");
        } else {
            bw.write(k + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
