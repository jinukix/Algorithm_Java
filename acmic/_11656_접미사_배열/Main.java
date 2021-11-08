package _11656_접미사_배열;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        ArrayList<String> list = new ArrayList<>(input.length());

        String s = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            s = input.charAt(i) + s;
            list.add(s);
        }

        Collections.sort(list);

        for (String value : list) {
            bw.write(value + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
