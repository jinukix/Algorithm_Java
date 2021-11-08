package _1254_팰린드롬;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        for (int i = 0; i <= input.length(); i++) {
            StringBuilder sb = new StringBuilder(input);
            sb.append(new StringBuilder(input.substring(0, i)).reverse());

            if (sb.toString().equals(sb.reverse().toString())) {
                bw.write(String.valueOf(sb.length()));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
