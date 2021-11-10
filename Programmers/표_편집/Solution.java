package 표_편집;

import java.util.Stack;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();

        for (String s : cmd) {
            char c = s.charAt(0);

            if (c == 'U') {
                k -= Integer.parseInt(s.split(" ")[1]);
            } else if (c == 'D') {
                k += Integer.parseInt(s.split(" ")[1]);
            } else if (c == 'C') {
                stack.push(k);
                n--;
                if (n == k) {
                    k--;
                }
            } else if (c == 'Z') {
                int r = stack.pop();
                if (r <= k) {
                    k++;
                }
                n++;
            }
        }

        StringBuilder sb = new StringBuilder("O".repeat(n));
        while (!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), 'X');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 2, new String[]{
            "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"
        }));
    }
}