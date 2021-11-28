package _1100_하얀칸;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();

            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && s.charAt(j) == 'F') {
                    result++;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
