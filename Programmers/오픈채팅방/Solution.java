package 오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (String str: record) {
            String[] strArr = str.split(" ");

            if (strArr[0].equals("Enter")) {
                list.add(strArr[1] + "님이 들어왔습니다.");
                map.put(strArr[1], strArr[2]);
            } else if (strArr[0].equals("Leave")) {
                list.add(strArr[1] + "님이 나갔습니다.");
            } else if (strArr[0].equals("Change")) {
                map.put(strArr[1], strArr[2]);
            }
        }

        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String id = str.substring(0, str.indexOf("님"));
            result[i] = str.replaceAll(id, map.get(id));
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