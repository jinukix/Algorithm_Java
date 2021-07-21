package 이진_변환_반복하기;

import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] ans = {0, 0};
        while (!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replaceAll("[0]", "");
            ans[1] += beforeLength - s.length();
            s = Integer.toBinaryString(s.length());
            ans[0]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("1111111")));
    }
}
