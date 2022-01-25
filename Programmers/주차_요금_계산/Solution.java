package 주차_요금_계산;

import java.util.HashMap;
import java.util.List;

class Solution {

    public int conversion(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> timeMap = new HashMap<>();

        for (String record : records) {
            String[] strs = record.split(" ");

            int time = conversion(strs[0]);
            if (strs[2].equals("IN")) {
                inMap.put(strs[1], time);
            } else {
                timeMap.put(strs[1], timeMap.getOrDefault(strs[1], 0)
                    + time - inMap.get(strs[1]));
                inMap.put(strs[1], -1);
            }
        }

        for (String key : inMap.keySet()) {
            if (inMap.get(key) != -1) {
                timeMap.put(key, timeMap.getOrDefault(key, 0)
                    + conversion("23:59") - inMap.get(key));
            }
        }

        List<String> carNumbers = timeMap.keySet().stream().sorted().toList();
        int size = carNumbers.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int useTime = timeMap.get(carNumbers.get(i)) - fees[0];
            if (0 >= useTime) {
                result[i] = fees[1];
            } else {
                result[i] = fees[1] + ((int) Math.ceil((double) useTime / fees[2]) * fees[3]);
            }
        }

        return result;
    }
}