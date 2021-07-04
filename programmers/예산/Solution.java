package 예산;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int cnt = 0;
        Arrays.sort(d);

        for (int i: d) {
            if (budget >= i) {
                budget-=i;
                cnt+=1;
            } else {
                break;
            }
        }

        return cnt;
    }

    // Test Case
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] d1 = {1, 3, 2, 5, 4};
        int[] d2 = {2, 2, 3, 3};
        int sol1 = 9;
        int sol2 = 10;

        System.out.println(sol.solution(d1, sol1));
        System.out.println(sol.solution(d2, sol2));
    }
}
