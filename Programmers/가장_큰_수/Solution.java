package 가장_큰_수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(((o1, o2) -> (o2+o1).compareTo(o1+o2)))
                .toArray(String[]::new);

        if (strArr[0].equals("0")) return "0";
        return String.join("", strArr);
    }
}