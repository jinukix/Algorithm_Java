package _1357_뒤집힌_덧셈;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder(st.nextToken());
        int x = Integer.parseInt(sb.reverse().toString());
        sb.setLength(0);

        sb.append(st.nextToken());
        int result = x + Integer.parseInt(sb.reverse().toString());
        sb.setLength(0);
        sb.append(result).reverse();

        bw.write(Integer.parseInt(sb.toString()) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
