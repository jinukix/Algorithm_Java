package 자릿수_더하기;

public class Solution {
    public int solution(int n) {
        String str = String.valueOf(n);
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i) - 48;
        }
        return ans;
    }
}
