package 디스크_컨트롤러;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(jobs));
        list.sort((o1, o2)->o1[0]-o2[0]);

        int now = 0;
        int result = 0;
        while (!list.isEmpty() || !priorityQueue.isEmpty()) {
            int idx = 0;
            while (idx < list.size() && list.get(idx)[0] <= now) {
                priorityQueue.add(list.get(idx));
                list.remove(idx);
            }

            if (priorityQueue.isEmpty()) {
                now++;
            } else {
                int[] tmp = priorityQueue.poll();
                result += now-tmp[0]+tmp[1];
                now += tmp[1];
            }
        }

        return result/jobs.length;
    }
}