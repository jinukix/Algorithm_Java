package 문자열을_정수로_바꾸기;

public class Solution {
    public int solution(String s) {
        if (s.charAt(0) == '-') {
            return Integer.parseInt(s.substring(1)) * -1;
        } else {
            return Integer.parseInt(s);
        }
    }
}
