package 정수_삼각형;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 1) return triangle[0][0];

        int[][] dp = new int[triangle.length][];

        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            dp[i] = new int[i+1];
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + gle[i][i];

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[][] {
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        });
    }
}
