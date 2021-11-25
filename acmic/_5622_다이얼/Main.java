package _5622_다이얼;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch < 'A') {
                break;
            } else if (ch < 'D') {
                result += 3;
            } else if (ch < 'G') {
                result += 4;
            } else if (ch < 'J') {
                result += 5;
            } else if (ch < 'M') {
                result += 6;
            } else if (ch < 'P') {
                result += 7;
            } else if (ch < 'T') {
                result += 8;
            } else if (ch < 'W') {
                result += 9;
            } else if (ch <= 'Z') {
                result += 10;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
