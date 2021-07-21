package 최대공약수와_최소공배수;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }

    static int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }

        return n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, 12)));
    }
}
