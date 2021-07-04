package 정수_내림차순으로_배치하기;

import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);
        StringBuilder ans = new StringBuilder();

        for (int i = arr.length-1; i >= 0; i--) {
            ans.append(arr[i]);
        }

        return Long.parseLong(ans.toString());
    }
}