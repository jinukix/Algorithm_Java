package 프린터;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        for (int priority : priorities) {
            queue.add(priority);
        }
        Arrays.sort(priorities);
        int idx = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == priorities[priorities.length - 1 - idx]) {
                idx++;
                if (location == 0) {
                    break;
                }
            } else {
                queue.add(n);
            }

            if (--location < 0) {
                location = queue.size() - 1;
            }
        }

        return idx;
    }
}