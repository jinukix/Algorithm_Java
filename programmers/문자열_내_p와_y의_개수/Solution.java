package 문자열_내_p와_y의_개수;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int cnt = 0;

        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == 'p') {
                cnt++;
            } else if (s.charAt(i) == 'y') {
                cnt--;
            }
        }

        return cnt==0;
    }
}