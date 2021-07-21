package 짝지어_제거하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.size() > 0 && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        if (stack.size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }
}