package _신고_결과_받기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    public int[] solution(String[] idList, String[] report, int k) {
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();

        Arrays.stream(idList).forEach(id -> {
            reportMap.put(id, new HashSet<>());
            cntMap.put(id, 0);
        });

        Arrays.stream(report).map(s -> s.split(" "))
            .forEach(reportInfo -> reportMap.get(reportInfo[1]).add(reportInfo[0]));

        reportMap.keySet().stream().filter(key -> k <= reportMap.get(key).size())
            .flatMap(key -> reportMap.get(key).stream())
            .forEach(elem -> cntMap.put(elem, cntMap.getOrDefault(elem, 0) + 1));

        return Arrays.stream(idList).mapToInt(cntMap::get).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
            Arrays.toString(sol.solution(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 2)));
    }
}