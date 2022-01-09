package 오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (String str : record) {
            String[] strs = str.split(" ");

            switch (strs[0]) {
                case "Enter" -> {
                    list.add(strs[1] + "님이 들어왔습니다.");
                    map.put(strs[1], strs[2]);
                }
                case "Leave" -> list.add(strs[1] + "님이 나갔습니다.");
                case "Change" -> map.put(strs[1], strs[2]);
            }
        }

        int size = list.size();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            String s = list.get(i);
            String id = s.substring(0, s.indexOf("님"));
            result[i] = s.replace(id, map.get(id));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        sol.solution(record);
    }
}