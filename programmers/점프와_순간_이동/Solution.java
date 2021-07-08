package 점프와_순간_이동;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (n != 0) {
            if (n%2 == 1) {
                n-=1;
                ans+=1;
            } else {
                n/=2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5000));
    }
}