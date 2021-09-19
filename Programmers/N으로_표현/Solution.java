package N으로_표현;

class Solution {
    int result = -1;
    public void dfs(int n, int num, int cnt, int val) {
        if (cnt >8) return;

        if (num == val){
            if (result > cnt || result == -1) result = cnt;
            return;
        }

        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(n, num, cnt + 1 + i, val + nn);
            dfs(n, num, cnt + 1 + i, val - nn);
            dfs(n, num, cnt + 1 + i, val * nn);
            dfs(n, num, cnt + 1 + i, val / nn);
        }
    }

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(5, 12);
    }
}