package _2512_예산;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int m = Integer.parseInt(br.readLine());
        int right = Arrays.stream(arr).max().getAsInt();
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = Arrays.stream(arr)
                .map(x -> Math.min(x, mid))
                .sum();

            if (sum < m) {
                left = mid + 1;
            } else if (sum > m) {
                right = mid - 1;
            } else {
                right = mid;
                break;
            }
        }

        bw.write(String.valueOf(right));
        bw.flush();
        bw.close();
        br.close();
    }
}