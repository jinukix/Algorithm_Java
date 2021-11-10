package 하노이의_탑;

import java.util.ArrayList;

class Solution {

    ArrayList<int[]> list = new ArrayList<>();

    public void hanoi(int count, int start, int middle, int end) {
        if (count == 1) {
            list.add(new int[]{start, end});
        } else {
            hanoi(count - 1, start, end, middle);
            list.add(new int[]{start, end});
            hanoi(count - 1, middle, start, end);
        }
    }

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}