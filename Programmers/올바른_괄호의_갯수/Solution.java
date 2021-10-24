package 올바른_괄호의_갯수;

class Solution {
    int result;
    public int solution(int n) {
        result = 0;

        dfs(0, 0, n);
        return result;
    }

    public void dfs(int open, int close, int n) {
        if (open < close || open > n || close > n) return;
        if (open == n && close == n) {
            result++;
            return;
        }

        dfs(open + 1, close, n);
        dfs(open, close + 1, n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3));
    }
}