package _3진법_뒤집기;

class Solution {

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 3);
            n /= 3;
        }

        return Integer.parseInt(sb.toString(), 3);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(125);
    }
}