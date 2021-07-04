package 모의고사;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = {0, 0, 0};

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                score[0]++;
            }

            if (answers[i] == student2[i % student2.length]) {
                score[1]++;
            }

            if (answers[i] == student3[i % student3.length]) {
                score[2]++;
            }
        }
        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < score.length; i++) {
            if(max == score[i]) {
              list.add(i+1);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
