package 징검다리_건너기;

class Solution {
    public int solution(int[] stones, int k) {
        int low = 1;
        int high = 200_000_000;
        int result = 0;

        while (low <= high){
            int mid = (low + high) / 2;
            if (!cross(stones, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = Math.max(result, mid);
            }
        }

        return result;
    }

    public static boolean cross(int[] stones, int k, int mid) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt == k){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {
                2,4,5,3,2,1,4,2,5,1
        }, 3));
    }
}