package 후보키;

import java.util.*;

class CandidateKey {

    String[] stringArr;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CandidateKey asd1 = (CandidateKey) o;

        int cnt = 0;
        for (int i = 0; i < stringArr.length; i++) {
            if (asd1.stringArr[i] == null || asd1.stringArr[i].equals(stringArr[i])) {
                cnt++;
            }
        }

        return (cnt == stringArr.length);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(stringArr);
    }
}

class Solution {

    ArrayList<Set<Integer>> result = new ArrayList<>();

    public int solution(String[][] relation) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < relation[0].length; i++) {
            set.clear();
            combination(set, 0, relation, i + 1);
        }

        return result.size();
    }

    void combination(Set<Integer> set, int start, String[][] relation, int end) {
        if (end == 0) {
            for (Set<Integer> s : result) {
                if (set.containsAll(s)) {
                    return;
                }
            }

            ArrayList<CandidateKey> l = new ArrayList<>();

            for (String[] strings : relation) {
                CandidateKey stringArr = new CandidateKey();
                stringArr.stringArr = new String[relation.length];
                int cnt = 0;

                for (Integer i : set) {
                    stringArr.stringArr[cnt++] = strings[i];
                }

                if (l.contains(stringArr)) {
                    return;
                }
                l.add(stringArr);
            }

            Set<Integer> newSet = new HashSet<>(set);
            result.add(newSet);
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            set.add(i);
            combination(set, i + 1, relation, end - 1);
            set.remove(i);
        }
    }
}