package 다트_게임;

class Solution {
    public int solution(String dartResult) {
        char[] darts = dartResult.toCharArray();
        int ans = 0;
        int score1= 0;
        int score2= 0;

        for (int i = 0; i < darts.length; i++) {
            boolean isTen = i > 1 && darts[i - 1] == '0' && darts[i - 2] == '1';
            if (darts[i] == 'S') {
                ans += score1;
                score1 = score2;

                if (isTen) {
                    score2 = 10;
                } else {
                    score2 = darts[i-1] - '0';
                }
            } else if (darts[i] == 'D') {
               ans += score1;
               score1 = score2;

               if (isTen) {
                    score2 = 10;
               } else {
                   score2 = darts[i-1] - '0';
               }
               score2*= score2;
           } else if (darts[i] == 'T') {
               ans += score1;
               score1 = score2;

               if (isTen) {
                    score2 = 10;
               } else {
                   score2 = darts[i-1] - '0';
               }
               score2*= score2 * score2;
           } else if (darts[i] == '*') {
               score1*=2;
               score2*=2;
           } else if (darts[i] == '#') {
               score2*=-1;
           }

        }

        return ans + score1 + score2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String dartResult = "1S2D*3T";
        System.out.println(sol.solution(dartResult));
    }
}