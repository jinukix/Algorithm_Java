package 문자열_내_마음대로_정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> arrayList = new ArrayList<String>();

        for (int i=0; i<strings.length; i++) {
            arrayList.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(arrayList);

        String[] ans = new String[strings.length];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i).substring(1);
        }
        return ans;
    }
}