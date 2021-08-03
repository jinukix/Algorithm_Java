package 순위_검색;

import java.util.*;

class Solution {
    static Map<String, ArrayList<Integer>> allInfo;

    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        allInfo = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            dfs("", 0, info[i].split(" "));
        }

        ArrayList<String> list = new ArrayList<>(allInfo.keySet());
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(allInfo.get(list.get(i)));
        }

        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] str = query[i].split(" ");
            result[i] = search(str[0], Integer.parseInt(str[1]));
        }

        return result;
    }

    static void dfs(String pos, int depth, String[] info) {
        if (depth==4) {
            if (!allInfo.containsKey(pos)) {
                ArrayList<Integer> scoreList = new ArrayList<>();
                scoreList.add(Integer.parseInt(info[4]));
                allInfo.put(pos, scoreList);
            } else {
                allInfo.get(pos).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(pos+"-", depth+1, info);
        dfs(pos+info[depth], depth+1, info);
    }

    static int search(String str, int score) {
        if (!allInfo.containsKey(str)) return 0;

        ArrayList<Integer> scoreList = allInfo.get(str);
        int start = 0;
        int end = scoreList.size()-1;

        while (start<=end) {
            int mid = (start+end) /2;

            if (scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scoreList.size()-start;
    }
}