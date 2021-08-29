package 베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (countMap.containsKey(genres[i])) {
                countMap.put(genres[i], countMap.get(genres[i]) + plays[i]);
                ArrayList<int[]> list = map.get(genres[i]);
                list.add(new int[] {i, plays[i]});
            } else {
                countMap.put(genres[i], plays[i]);
                ArrayList<int[]> list = new ArrayList<>();
                list.add(new int[] {i, plays[i]});
                map.put(genres[i], list);
            }
        }

        ArrayList<String> listKeySet = new ArrayList<>(countMap.keySet());
        listKeySet.sort((o1, o2) -> countMap.get(o2) - countMap.get(o1));

        ArrayList<Integer> resultList = new ArrayList<>();
        for (String key : listKeySet) {
            ArrayList<int[]> list = map.get(key);

            if (list.size() >= 2) {
                list.sort((o1, o2) -> { return o2[1] - o1[1]; });
                resultList.add(list.get(0)[0]);
                resultList.add(list.get(1)[0]);
            } else {
                resultList.add(list.get(0)[0]);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {2000, 2000, 2000, 2000, 2000};
        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }
}