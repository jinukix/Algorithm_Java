package 자연수_뒤집어_배열로_만들기;

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] ans = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ans[i] = str.charAt(str.length()-i-1) - 48;
        }

        return ans;
    }
}