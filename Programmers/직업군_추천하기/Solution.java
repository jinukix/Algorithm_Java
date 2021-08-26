package 직업군_추천하기;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String result = "";
        int maxScore = 0;

        ArrayList<String> list;
        for (int i = 0; i < table.length; i++) {
            list = new ArrayList<>(Arrays.asList(table[i].split(" ")));
            int score = 0;
            for (int j = 0; j < languages.length; j++) {
                if (!list.contains(languages[j])) continue;
                score += preference[j] * (6-list.indexOf(languages[j]));
            }

            if (maxScore == score && result.compareTo(list.get(0)) > 0 || score > maxScore) {
                result = list.get(0);
                maxScore = score;
            }
        }

        return result;
    }
}