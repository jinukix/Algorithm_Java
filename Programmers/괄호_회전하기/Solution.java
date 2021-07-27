package 괄호_회전하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (isCorrectBracket(s)) result++;
        }

        return result;
    }

    public boolean isCorrectBracket(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    stack.add(ch);
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol= new Solution();
        sol.solution("{}{}{}{}1");
    }
}