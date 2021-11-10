package 키패드_누르기;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    Integer[][] arr = {
        {1, 1}, {1, 2}, {1, 3},
        {2, 1}, {2, 2}, {2, 3},
        {3, 1}, {3, 2}, {3, 3},
        {4, 1}, {4, 2}, {4, 3},
    };
    HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>() {
        {
            put(1, arr[0]);
            put(2, arr[1]);
            put(3, arr[2]);
            put(4, arr[3]);
            put(5, arr[4]);
            put(6, arr[5]);
            put(7, arr[6]);
            put(8, arr[7]);
            put(9, arr[8]);
            put(10, arr[9]); // *
            put(0, arr[10]); // 0
            put(12, arr[11]); // #
        }
    };

    public int getLength(int from, int to) {
        int lengthY = Math.abs(map.get(from)[0] - map.get(to)[0]);
        int lengthX = Math.abs(map.get(from)[1] - map.get(to)[1]);

        return lengthY + lengthX;
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftFrom = 10;
        int rightFrom = 12;

        for (int n : numbers) {
            if (n % 3 == 2 || n == 0) {
                int leftLength = getLength(leftFrom, n);
                int rightLength = getLength(rightFrom, n);

                if (leftLength > rightLength) {
                    sb.append("R");
                    rightFrom = n;
                } else if (leftLength < rightLength) {
                    sb.append("L");
                    leftFrom = n;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightFrom = n;
                    } else if (hand.equals("left")) {
                        sb.append("L");
                        leftFrom = n;
                    }
                }
            } else if (n % 3 == 1) {
                sb.append("L");
                leftFrom = n;
            } else if (n % 3 == 0) {
                sb.append("R");
                rightFrom = n;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
//        System.out.println(sol.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
