package _2016년;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class Solution {

    public String solution(int a, int b) {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);

        return new SimpleDateFormat("E", Locale.ENGLISH)
            .format(cal.getTime())
            .toUpperCase();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 24));
    }
}