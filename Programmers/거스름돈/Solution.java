package 거스름돈;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        Arrays.stream(money).forEach(
            i -> IntStream.range(1, n + 1)
                .filter(j -> j >= i)
                .forEach(j -> dp[j] += dp[j - i]));

        return dp[n] % 1_000_000_007;
    }
}