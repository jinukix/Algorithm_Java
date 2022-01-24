package _신고_결과_받기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    public int[] solution(String[] idList, String[] report, int k) {
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();

        for (String id : idList) {
            reportMap.put(id, new HashSet<>());
            cntMap.put(id, 0);
        }

        for (String s : report) {
            String[] reportInfo = s.split(" ");
            reportMap.get(reportInfo[1]).add(reportInfo[0]);
        }

        for (String key : reportMap.keySet()) {
            if (k <= reportMap.get(key).size()) {
                for (String elem : reportMap.get(key)) {
                    cntMap.put(elem, cntMap.getOrDefault(elem, 0) + 1);
                }
            }
        }

        int[] result = new int[idList.length];
        for (int i = 0; i < idList.length; i++) {
            result[i] = cntMap.get(idList[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
            Arrays.toString(sol.solution(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 2)));
    }
}