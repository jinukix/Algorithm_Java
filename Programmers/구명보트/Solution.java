package 구명보트;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int solution(int[] people, int limit) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Arrays.sort(people);
        for (int person: people) {
            deque.addLast(person);
        }

        int ans = 0;
        while (deque.size() > 0) {
            if (deque.peekFirst() + deque.peekLast() <= limit) {
                deque.pollFirst();
            }
            deque.pollLast();
            ans+=1;
        }

        return ans;
    }
}