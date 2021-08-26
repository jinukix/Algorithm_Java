package 야근_지수;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work:works) {
            priorityQueue.add(work);
        }

        for (int i = 0; i < n; i++) {
            int x = priorityQueue.poll();
            if (x--==0) return 0;
            priorityQueue.add(x);
        }

        return priorityQueue.stream().mapToLong(x -> (long) x*x).sum();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4, new int[] {4,3,3}));
    }
}