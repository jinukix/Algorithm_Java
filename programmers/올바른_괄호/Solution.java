package 올바른_괄호;

class Solution {
    boolean solution(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ans+=1;
            } else if (s.charAt(i) == ')') {
                ans-=1;
            }

            if (ans<0) {
                return false;
            }
        }

        return ans == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(")()("));
    }
}