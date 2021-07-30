package 예상_대진표;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int a, int b) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }

        int winner = 0;
        while (true) {
            Integer x = queue.poll();
            Integer y = queue.poll();

            if (x==a && y==b || x==b && y==a) break;

            if (x==a || x==b) winner = x;
            else winner = y;

            if (winner == a) result++;

            queue.add(winner);
        }

        return ++result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8,4,7);
    }
}
