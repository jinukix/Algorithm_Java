package _2016년;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a-1, b);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);

        answer = sdf.format(date).toUpperCase();
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 24));
    }
}