package 뉴스_클러스터링;

import java.util.HashSet;

class Solution {
    public HashSet<String> getSet(String str) {
        HashSet<String> set = new HashSet<>();
        String elem;
        for (int i = 0; i < str.length()-1; i++) {
            elem = str.substring(i, i+2);
            if (elem.matches("[a-z]{2}")) {
                if (set.contains(elem)) {
                    String tempElem = elem;
                    int cnt = 0;
                    while (set.contains(tempElem)) {
                        tempElem = elem;
                        tempElem += "" + ++cnt;
                    }

                    elem += "" + cnt;
                }

                set.add(elem);
            }
        }

        return set;
    }

    public int solution(String str1, String str2) {
        HashSet<String> set1 = getSet(str1.toLowerCase());
        HashSet<String> set2 = getSet(str2.toLowerCase());

        if (set1.isEmpty() && set2.isEmpty()) return 65536;

        HashSet<String> tempSet1 = (HashSet<String>) set1.clone();
        tempSet1.addAll(set2);
        set1.retainAll(set2);

        double result = (set2.size() / (double) set1.size()) * 65536;
        return (int) result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("FRANCE", "french"));
    }
}