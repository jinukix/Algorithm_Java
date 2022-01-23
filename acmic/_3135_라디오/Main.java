package _3135_라디오;

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

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int min = Math.abs(a - b);
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            min = Math.min(Math.abs(b - k)+1, min);
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
