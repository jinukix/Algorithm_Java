package 단어_변환;

import java.util.*;

class Solution {
    public boolean canChange(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) cnt++;
            if (cnt >= 2) return false;
        }

        return cnt==1;
    }

    public int solution(String begin, String target, String[] words) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(words));
        HashMap<String, Integer> countMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        if (!list.contains(target)) return 0;
        queue.add(begin);
        countMap.put(begin, 0);

        whileLoop:
        while (!queue.isEmpty()) {
            begin = queue.poll();
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (canChange(begin, s)) {
                    countMap.put(s, countMap.get(begin)+1);
                    queue.add(s);
                    list.remove(i);
                    i--;

                    if (s.equals(target)) {
                        break whileLoop;
                    }
                }
            }
        }

        return countMap.get(target);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
           "hit", "cog",
           new String[] {"hot", "dot", "dog", "lot", "log", "cog"}
        ));
    }
}