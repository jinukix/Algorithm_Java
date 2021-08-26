package 튜플;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "");
        s = s.substring(0, s.length()-1) + ",";

        String[] tuples = s.split("},");
        Arrays.sort(tuples, (a, b) -> a.length() - b.length());

        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[tuples.length];
        for (int i = 0; i < tuples.length; i++) {
            String[] strNums = tuples[i].split(",");

            for (String strNum: strNums) {
                int num = Integer.parseInt(strNum);

                if (!set.contains(num)) {
                    set.add(num);
                    result[i] = num;
                    break;
                }
            }
        }

        return result;
    }
}