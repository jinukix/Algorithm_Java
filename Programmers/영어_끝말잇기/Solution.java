package 영어_끝말잇기;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        char prevChar = words[0].charAt(words[0].length()-1);
        list.add(words[0]);

        int[] ans = {0, 0};
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != prevChar || list.contains(words[i]) || words[i].length() == 1) {
                ans[0] = i%n + 1;
                ans[1] = i/n + 1;
                break;
            }

            prevChar = words[i].charAt(words[i].length()-1);
            list.add(words[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {
                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
        };
        System.out.println(Arrays.toString(sol.solution(3, words)));
    }
}