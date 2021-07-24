package 가장_큰_수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strings[0].equals("0")) return "0";

        StringBuilder ans = new StringBuilder();
        for (String str:strings) {
            ans.append(str);
        }
        return ans.toString();
    }
}