package _2022_사다리;

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = y;
        while (true) {
            double mid = (left+right)/2;

            double d1 = Math.sqrt(x*x-mid*mid);
            double d2 = Math.sqrt(y*y-mid*mid);
            double myC = (d1*d2)/(d1+d2);

            if (Math.abs(myC - c) <= 0.001) {
                bw.write(mid + "");
                break;
            }

            if (myC > c) {
                left = mid;
            } else {
                right = mid;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
