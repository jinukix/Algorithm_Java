package _16953_A에서B;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = 1;
        while (a != b) {
            result++;
            if (a>b) {
                result = -1;
                break;
            }

            if (b % 10 == 1) {
                b/= 10;
            } else if (b % 2 == 0){
                b/= 2;
            } else {
                result = -1;
                break;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
