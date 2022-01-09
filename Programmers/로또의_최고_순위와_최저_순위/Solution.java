package 로또의_최고_순위와_최저_순위;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        Set<Integer> set = new HashSet<>();

        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
            }
            set.add(lotto);
        }

        int minCnt = 0;
        for (int winNum : win_nums) {
            if (set.contains(winNum)) {
                minCnt++;
            }
        }

        int maxCnt = minCnt + zeroCnt;
        int maxRank = maxCnt != 0 ? Math.abs(7 - maxCnt) : 6;
        int minRank = minCnt != 0 ? Math.abs(7 - minCnt) : 6;

        return new int[]{maxRank, minRank};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(
            solution.solution(new int[]{5, 5, 5, 5, 5, 5}, new int[]{45, 4, 35, 20, 3, 9})));
    }
}