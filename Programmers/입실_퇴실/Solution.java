package 입실_퇴실;

import java.util.HashSet;

public class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int len = enter.length;
        HashSet<Integer> roomSet = new HashSet<>(len);
        HashSet<Integer>[] countSet = new HashSet[len];

        for (int i = 0; i < len; i++) {
            countSet[i] = new HashSet<>();
        }

        int enterIdx = 0;
        int leaveIdx = 0;
        for (int i = 0; i < len *2; i++) {
            if (roomSet.contains(leave[leaveIdx])) {
                roomSet.remove(leave[leaveIdx++]);
            } else {
                int ent = enter[enterIdx];
                if (!roomSet.isEmpty()) {
                    for (Integer x:roomSet) {
                        countSet[x-1].add(ent);
                    }
                }

                countSet[ent-1].addAll(roomSet);
                roomSet.add(ent);
                enterIdx++;
            }
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = countSet[i].size();
        }

        return result;
    }
}