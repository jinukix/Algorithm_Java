package 로또의_최고_순위와_최저_순위;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int winCount = 0;
        int eraseCount = 0;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n: win_nums) {
            arrayList.add(n);
        }

        for (int n: lottos) {
            if (n==0) {
                eraseCount++;
            } else if (arrayList.contains(n)) {
                winCount++;
            }
        }

        int bestScore = (7-(winCount+eraseCount) != 7) ? 7-(winCount+eraseCount) : 6;
        int worstScore = (7-winCount != 7) ? 7-winCount : 6;

        return new int[]{bestScore, worstScore};
    }
}