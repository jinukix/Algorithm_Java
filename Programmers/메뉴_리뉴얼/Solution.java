package 메뉴_리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {

    HashMap<String, Integer> map = new HashMap<>();

    public void combination(String order, int n, int start, StringBuilder sb) {
        if (sb.length() == n) {
            char[] sortChars = sb.toString().toCharArray();
            Arrays.sort(sortChars);
            String sortStr = new String(sortChars);
            map.put(sortStr, map.getOrDefault(sortStr, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            if (sb.indexOf(String.valueOf(order.charAt(i))) == -1) {
                combination(order, n, i + 1, sb.append(order.charAt(i)));
                sb.deleteCharAt(sb.indexOf(String.valueOf(order.charAt(i))));
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        for (int n : course) {
            for (String order : orders) {
                sb.delete(0, sb.length());
                combination(order, n, 0, sb);
            }

            if (map.isEmpty()) {
                continue;
            }

            ArrayList<Map.Entry<String, Integer>> li = new ArrayList<>(map.entrySet());
            li.sort(Map.Entry.comparingByValue());
            Collections.reverse(li);

            int maxCnt = li.get(0).getValue();
            if (maxCnt >= 2) {
                for (Map.Entry<String, Integer> entry : li) {
                    if (entry.getValue() == maxCnt) {
                        list.add(entry.getKey());
                    } else {
                        break;
                    }
                }
            }

            map.clear();
        }

        Collections.sort(list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        sol.solution(orders, course);
    }
}