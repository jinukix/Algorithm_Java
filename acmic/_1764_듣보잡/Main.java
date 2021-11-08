package _1764_듣보잡;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (String s : result) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
