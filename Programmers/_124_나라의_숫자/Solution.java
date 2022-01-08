package _124_나라의_숫자;

class Solution {

    public String solution(int n) {
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            n -= 1;
            ans.insert(0, "124".charAt(n % 3));
            n = n / 3;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
    }
}