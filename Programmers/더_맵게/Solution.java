package 더_맵게;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i :scoville) {
            priorityQueue.add(i);
        }

        int result = 0;
        while (true) {
            if (priorityQueue.peek() > k) break;

            if (priorityQueue.size() < 2) {
                result = -1;
                break;
            }

            int x = priorityQueue.poll();
            int y = priorityQueue.poll();

            priorityQueue.add(x + (2*y));
            result++;
        }

        return result;
    }
}
