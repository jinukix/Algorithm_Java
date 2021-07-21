package 압축;

import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char ch = (char) (65 + i);
            strList.add(ch + "");
        }

        int start = 0;
        while (true) {
            String str = "" + msg.charAt(start);

            while (start+1 < msg.length() && strList.contains(str + msg.charAt(start+1))) {
                str += msg.charAt(++start);
            }

            if (start+1 >= msg.length()) {
                intList.add(strList.indexOf(str)+1);
                break;
            }

            strList.add(str + msg.charAt(++start));
            intList.add(strList.indexOf(str)+1);
        }

        int[] ans = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            ans[i] = intList.get(i);
        }

        return ans;
    }
}