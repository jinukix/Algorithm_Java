package _1343_폴리오미노;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int cnt = 0;
        for (char ch : input.toCharArray()) {
            if (ch == '.') {
                if (cnt % 2 == 1) {
                    break;
                }

                while (cnt != 0) {
                    if (cnt >= 4) {
                        sb.append("AAAA");
                        cnt -= 4;
                    } else {
                        sb.append("BB");
                        cnt -= 2;
                    }
                }

                sb.append(".");
            } else {
                cnt++;
            }
        }

        if (cnt > 0) {
            if (cnt % 2 == 1) {
                sb = new StringBuilder("-1");
            } else {
                while (cnt != 0) {
                    if (cnt >= 4) {
                        sb.append("AAAA");
                        cnt -= 4;
                    } else {
                        sb.append("BB");
                        cnt -= 2;
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
