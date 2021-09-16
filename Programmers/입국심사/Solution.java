package 입국심사;

class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 1_000_000_000 * (long)n;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid +1;
            } else {
                right = mid -1;
                result = mid;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
            6, new int[] {7,10}
        ));
    }
}