package 약수의_개수와_덧셈;

public class Solution {
    public int solution(int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) {
            int cnt = getDivisorCount(i);

            if (cnt%2 == 0) {
                ans += i;
            } else {
                ans -= i;
            }
        }
        return ans;
    }

    public int getDivisorCount(int num){
        int cnt = 0;
        for (int i = 1; i <= (int)Math.sqrt(num); i++) {
            if (num%i==0){
                if (num == i*i) {
                    cnt++;
                } else {
                    cnt+=2;
                }
            }
        }
        return cnt;
    }
}
