package 문자열_내림차순으로_배치하기;

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars);
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
