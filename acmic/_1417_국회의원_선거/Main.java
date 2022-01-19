package _1417_국회의원_선거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int myCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int x = Integer.parseInt(br.readLine());
            if (myCnt <= x) {
                priorityQueue.add(-x);
            }
        }

        int result = 0;
        while (!priorityQueue.isEmpty()) {
            int cnt = priorityQueue.poll();
            if (myCnt <= -cnt) {
                result++;
                myCnt++;
                priorityQueue.add(cnt + 1);
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
