package 가장_긴_팰린드롬;

class Solution {
    public int solution(String s) {
        int result = 1;
        int l = s.length();
        char[] chars= s.toCharArray();
        int[][] dp = new int[l][l];

        for (int i = 0; i < l; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < l-1; i++) {
            if (chars[i] == chars[i+1]) {
                dp[i][i+1] = 1;
                result = 2;
            }
        }

        for (int i = 2; i < l; i++) {
            for (int start = 0; start < l-i; start++) {
                int end = start+i;

                if (chars[start] == chars[end] && dp[start+1][end-1] == 1) {
                    dp[start][end] = 1;
                    result = Integer.max(result, i+1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abcdcbaxabcdcba"));
    }
}