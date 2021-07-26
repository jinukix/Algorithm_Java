package 위장;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }

        for (Integer value:map.values()) {
            result += (result*value) + value;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] clothes = {
                {"crowmask", "face"},
                {"crowmask", "face1"},
                {"crowmask", "face1"},
                {"bluesunglasses", "face2"},
        };
        sol.solution(clothes);
    }
}
