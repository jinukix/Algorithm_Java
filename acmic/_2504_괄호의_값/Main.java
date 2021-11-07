package _2504_괄호의_값;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Stack<Integer> st = new Stack<>();

        int temp = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(2);
                temp *= 2;
            } else if (s.charAt(i) == '[') {
                st.add(3);
                temp *= 3;
            } else {
                if (st.size() == 0) {
                    result = 0;
                    break;
                }

                if (s.charAt(i) != ']' && s.charAt(i) != ')') {
                    result = 0;
                    break;
                }

                if ((s.charAt(i) == ']' && st.peek() == 2) || (s.charAt(i) == ')'
                    && st.peek() == 3)) {
                    result = 0;
                    break;
                }

                int cur = 2;
                if (s.charAt(i) == ']') {
                    cur = 3;
                }

                if (st.size() == 0 || (s.charAt(i - 1) == '(' && cur == 2) || (
                    s.charAt(i - 1) == '[' && cur == 3)) {
                    result += temp;
                }

                st.pop();
                temp /= cur;
            }
        }

        if (st.size() != 0) {
            result = 0;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
