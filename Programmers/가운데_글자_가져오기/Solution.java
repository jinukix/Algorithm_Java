package 가운데_글자_가져오기;

class Solution {

    public String solution(String s) {
        int len = s.length();

        int start = len / 2;
        if (len % 2 != 1) {
            start--;
        }

        int end = len / 2 + 1;
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abcd"));
    }
}