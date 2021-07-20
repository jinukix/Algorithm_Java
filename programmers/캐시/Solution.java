package 캐시;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int ans = 0;
        if (cacheSize == 0) return cities.length * 5;

        for (String city : cities) {
            city = city.toLowerCase();
            if (!queue.contains(city)) {
                if (queue.size() >= cacheSize) queue.poll();
                queue.offer(city);
                ans += 5;
            } else {
                queue.remove(city);
                queue.offer(city);
                ans+=1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(sol.solution(cacheSize, cities));
    }
}

