package 이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation:operations) {
            if (operation.charAt(0) == 'I') {
                priorityQueue.add(Integer.valueOf(operation.substring(2)));
                reversePriorityQueue.add(Integer.valueOf(operation.substring(2)));
            } else if (!priorityQueue.isEmpty()) {
                if (operation.equals("D -1")) { // 최솟값
                    int x = priorityQueue.poll();
                    reversePriorityQueue.remove(x);
                } else if (operation.equals("D 1")) { // 최댓값
                    int x = reversePriorityQueue.poll();
                    priorityQueue.remove(x);
                }
            }
        }

        if (priorityQueue.isEmpty()) return new int[] {0, 0};
        return new int[]{reversePriorityQueue.poll(), priorityQueue.poll()};
    }
}
