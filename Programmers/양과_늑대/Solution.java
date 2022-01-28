package 양과_늑대;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    private static int maxSheepCount = 0;
    private static Map<Integer, List<Integer>> map;

    public void dfs(int idx, int s, int w, List<Integer> list, int[] info) {
        if (info[idx] == 0) {
            s++;
            maxSheepCount = Math.max(maxSheepCount, s);
        } else {
            w++;
            if (s <= w) {
                return;
            }
        }

        List<Integer> cloneList = new LinkedList<>(list);
        if (map.containsKey(idx)) {
            cloneList.addAll(map.get(idx));
        }
        cloneList.remove(Integer.valueOf(idx));

        for (int n : cloneList) {
            dfs(n, s, w, cloneList, info);
        }
    }

    public int solution(int[] info, int[][] edges) {
        map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new LinkedList<>());
            }
            map.get(edge[0]).add(edge[1]);
        }

        List<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(0, 0, 0, new LinkedList<>(), info);
        return maxSheepCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            new int[][]{
                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6},
                {8, 9}
            }));
    }
}