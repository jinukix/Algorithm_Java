package _2846_오르막길;

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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        int low = 0;
        int beforeH = 0;
        for (int i = 0; i < n; i++) {
            int currentH = Integer.parseInt(st.nextToken());

            if (currentH <= beforeH || i == 0) {
                result = Math.max(result, beforeH - low);
                low = currentH;
            }

            beforeH = currentH;
        }

        bw.write(Math.max(result, beforeH - low) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
