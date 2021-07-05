package 소수_만들기;

public class Solution {
    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum =  nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
