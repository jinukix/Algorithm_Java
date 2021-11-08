package _2720_세탁소_사장_동혁;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int quarter = n / 25;
            n %= 25;

            int dime = (n) / 10;
            n %= 10;

            int nickel = (n) / 5;
            n %= 5;

            int penny = n;

            bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
