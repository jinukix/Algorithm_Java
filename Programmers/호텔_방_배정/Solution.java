package 호텔_방_배정;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public long[] solution(long k, long[] roomNumbers) {

        HashMap<Long, Long> rooms = new HashMap<>();
        long[] result = new long[roomNumbers.length];

        for (int i = 0; i < roomNumbers.length; i++) {

            ArrayList<Long> list = new ArrayList<>();
            long roomNumber = roomNumbers[i];

            if (!rooms.containsKey(roomNumber)) {
                rooms.put(roomNumber, roomNumber + 1);
            } else {
                list.add(roomNumber);

                while (rooms.containsKey(roomNumber)) {
                    roomNumber = rooms.get(roomNumber);
                    list.add(roomNumber);
                }

                for (Long l : list) {
                    rooms.put(l, roomNumber + 1);
                }
            }

            result[i] = roomNumber;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }
}