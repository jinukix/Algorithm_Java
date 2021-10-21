package _2470_두_용액;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;

        int result1 = 0;
        int result2 = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < min) {
                min = absSum;
                result1 = arr[left];
                result2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(result1 + " " + result2);
        bw.flush();
        bw.close();
        br.close();
    }
}