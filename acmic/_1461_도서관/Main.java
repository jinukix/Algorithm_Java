package _1461_도서관;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x < 0) {
                minusPq.add(x);
            } else {
                plusPq.add(x);
            }
        }

        int result = 0;

        int min = 0;
        if (!minusPq.isEmpty()) {
            min = minusPq.peek();
        }

        int max = 0;
        if (!plusPq.isEmpty()) {
            max = plusPq.peek();
        }
        result -= Math.max(max, -min);

        while (m < plusPq.size()) {
            result += (plusPq.poll() * 2);
            for (int i = 0; i < m - 1; i++) {
                plusPq.poll();
            }
        }

        if (!plusPq.isEmpty()) {
            result += (plusPq.poll() * 2);
        }

        while (m < minusPq.size()) {
            result -= (minusPq.poll() * 2);
            for (int i = 0; i < m - 1; i++) {
                minusPq.poll();
            }
        }

        if (!minusPq.isEmpty()) {
            result -= (minusPq.poll() * 2);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
