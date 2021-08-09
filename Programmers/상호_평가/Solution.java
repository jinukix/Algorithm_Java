package 상호_평가;

class Solution {
    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();

        int score;
        for (int i = 0; i < scores[0].length; i++) {
            int selfScore = scores[i][i];
            boolean isMax = true;
            boolean isMin = true;

            int sum = selfScore;
            for (int j = 0; j < scores.length; j++) {
                if (i==j) continue;
                if (scores[j][i] <= selfScore) isMax = false;
                if (scores[j][i] >= selfScore) isMin = false;

                sum += scores[j][i];
            }

            if (isMax || isMin) {
                score = (sum-selfScore)/(scores[0].length-1);
            } else {
                score = sum/scores[0].length;
            }

            if (score >= 90) {
                sb.append("A");
            } else if (score >= 80) {
                sb.append("B");
            } else if (score >= 70) {
                sb.append("C");
            } else if (score >= 50) {
                sb.append("D");
            } else {
                sb.append("F");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] scores = {
            {100,90,98,88,65},
            {50,45,99,85,77},
            {47,88,95,80,67},
            {61,57,100,80,65},
            {24,90,94,75,65}
        };

        Solution sol = new Solution();
        sol.solution(scores);
    }
}