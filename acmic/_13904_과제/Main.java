package _13904_과제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            maxDay = Math.max(maxDay, d);
            if (!map.containsKey(d)) {
                map.put(d, new ArrayList<>());
            }

            map.get(d).add(w);
        }

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = maxDay; i > 0; i--) {
            if (map.containsKey(i)) {
                pq.addAll(map.get(i));
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
