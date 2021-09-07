package 모음_사전;

import java.util.ArrayList;

public class Solution {
    char[] chars = {'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> list;
    String word;
    int result = 0;

    public int solution(String word) {
        this.word = word;
        list = new ArrayList<>(10000);

        for (char aChar : chars) {
            addString("", aChar);
        }

        return result;
    }

    private void addString(String s, char c) {
        String str = s + c;
        list.add(str);

        if (str.equals(word)) result = list.size();
        if (str.length() >= 5 || result != 0) return;

        for (char aChar : chars) {
            addString(str, aChar);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("EAAAA");
    }
}
