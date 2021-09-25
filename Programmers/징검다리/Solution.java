package 징검다리;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }

    public int binarySearch(int distance, int[] rocks, int n) {
        long left = 1;
        long right = distance;
        long mid;
        int result = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    cnt++;
                } else {
                    prev = rock;
                }
            }

            if (distance - prev < mid) cnt++;

            if (cnt <= n) {
                left = mid + 1;
                result = (int) Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(25, new int[] {2,14,11,21,17}, 2));
    }
}