package 숫자의_표현;

class Solution {
    public int solution(int n) {
        int ans = 1;
        for (int i = 1; i < n/2+1; i++) {
            int sum = i;

            for (int j = i+1; j < n; j++) {
                sum += j;
                if (sum == n) {
                    ans++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return ans;
    }
}