package 다리를_지나는_트럭;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Deque<Integer> deque = new ArrayDeque<>(bridgeLength);
        for (int i = 0; i < bridgeLength; i++) {
            deque.add(0);
        }

        int sum = 0;
        int idx = 0;
        int result = 0;

        while (idx < truckWeights.length) {
            result++;
            sum -= deque.pollLast();

            if (sum+truckWeights[idx] <= weight) {
                deque.addFirst(truckWeights[idx]);
                sum += truckWeights[idx++];
            } else {
                deque.addFirst(0);
            }
        }

        return result+bridgeLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] truckWeights = {7,4,5,6};
        sol.solution(2, 10, truckWeights);
    }
}
