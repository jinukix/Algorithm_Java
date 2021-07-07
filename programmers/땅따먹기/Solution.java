package 땅따먹기;

import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k==j) continue;
                    if (max < dp[i-1][k]) max = dp[i-1][k];
                }

                dp[i][j] = land[i][j] + max;
            }
        }
        int ans = dp[land.length-1][0];
        for (int i = 1; i < dp[land.length-1].length; i++) {
            ans = Math.max(ans, dp[land.length-1][i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
        System.out.println(sol.solution(land));
    }
}