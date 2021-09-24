package 도둑질;

class Solution {
    public int solution(int[] money) {
        int l = money.length;
        int[] dp1 = new int[l];
        int[] dp2 = new int[l];

        dp1[0] = money[0];
        dp1[1] = money[0];

        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < l-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        dp1[l-1] = dp1[l-2];
        dp2[l-1] = Math.max(dp2[l-2], dp2[l-3] + money[l-1]);

        return Math.max(dp1[l-1], dp2[l-1]);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1,1,1000,1,1,1000}));
    }
}