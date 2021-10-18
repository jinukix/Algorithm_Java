package _1072_게임;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int z = (int) ((long) y*100 / x);

        int result = -1;
        if (z < 99) {
            int left = 1;
            int right = x;
            int mid;

            while (left <= right) {
                mid = (left+right) /2;
                int zz = (int) ((long) (y+mid)*100/(x+mid));

                if (z+1 <= zz) {
                    right = mid-1;
                    result = mid;
                } else if (z+1 > zz) {
                    left = mid+1;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
