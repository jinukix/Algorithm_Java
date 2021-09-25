package _2417_정수_제곱근;

import java.io.*;

public class Main {
    public static long solution(long n) {
        long result = 0;

        if (n==0) {
            result = 0;
        } else if (n <= 3) {
            result = 1;
        } else {
            long start = 1;
            long end = n/2;
            long mid;

            while (start < end) {
                mid = (start + end) /2;

                if (Math.pow(mid, 2) >= n) {
                    end = mid;
                    result = mid;
                } else {
                    start = mid+1;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = solution(n);
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

// 122333444455555
// 11060446