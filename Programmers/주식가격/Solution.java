package 주식가격;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                result[i]++;
                if (prices[i] > prices[j]) break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
}
