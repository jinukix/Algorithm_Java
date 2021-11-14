package _11720_숫자의_합;

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
        String input = br.readLine();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
