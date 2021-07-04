package 소수_찾기;


class Solution {
    public int solution(int n) {
        boolean[] decimal = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            decimal[i]= true;
        }

        int root = (int)Math.sqrt(n);

        for (int i = 2; i <= root; i++) {
            if (decimal[i]) {
                for (int j = i; i*j <=n; j++) {
                    decimal[i*j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(decimal[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}