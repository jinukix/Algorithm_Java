package _2309_일곱_난쟁이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        loop:
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (arr[i] + arr[j] == sum-100) {
                    arr[i] = 100;
                    arr[j] = 100;
                    break loop;
                }
            }
        }

        Arrays.sort(arr);
        for (int i = 0; i < 7; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
