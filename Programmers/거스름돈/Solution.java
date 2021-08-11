package 거스름돈;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i:money) {
            for (int j = 1; j < n+1; j++) {
                if (j>=i) dp[j] += dp[j-i];
            }
        }

        return dp[n] % 1_000_000_007;
    }
}