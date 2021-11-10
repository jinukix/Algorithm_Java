package _110_옮기기;

import java.util.Stack;

class Solution {

    public String conversion(String s) {
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= 3) {
                if (stack.peek() != '0') {
                    continue;
                }
                char ch1 = stack.pop();

                if (stack.peek() != '1') {
                    stack.push(ch1);
                    continue;
                }
                char ch2 = stack.pop();

                if (stack.peek() != '1') {
                    stack.push(ch2);
                    stack.push(ch1);
                    continue;
                }

                stack.pop();
                cnt++;
            }
        }

        if (cnt == 0) {
            return s;
        }

        int idx = stack.size();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            if (!flag && stack.peek() == '1') {
                idx--;
            }
            if (!flag && stack.peek() == '0') {
                flag = true;
            }

            sb.insert(0, stack.pop());
        }

        for (int i = 0; i < cnt; i++) {
            sb.insert(idx, "110");
            idx += 3;
        }

        return sb.toString();
    }

    public String[] solution(String[] s) {
        String[] result = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = conversion(s[i]);
        }

        return result;
    }
}