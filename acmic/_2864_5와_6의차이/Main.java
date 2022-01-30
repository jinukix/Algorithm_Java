package _2864_5와_6의차이;

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

        String a = st.nextToken();
        String b = st.nextToken();

        int maxA = Integer.parseInt(a.replaceAll("5", "6"));
        int maxB = Integer.parseInt(b.replaceAll("5", "6"));
        int minA = Integer.parseInt(a.replaceAll("6", "5"));
        int minB = Integer.parseInt(b.replaceAll("6", "5"));

        bw.write((minA + minB) + " " + (maxA + maxB));
        bw.flush();
        bw.close();
        br.close();
    }
}
