package 나머지_한_점;

import java.util.Arrays;

class Solution {

    public int[] solution(int[][] v) {
        int[] result = new int[2];
        if (v[0][0] == v[1][0]) {
            result[0] = v[2][0];
        } else if (v[0][0] == v[2][0]) {
            result[0] = v[1][0];
        } else if (v[1][0] == v[2][0]) {
            result[0] = v[0][0];
        }

        if (v[0][1] == v[1][1]) {
            result[1] = v[2][1];
        } else if (v[0][1] == v[2][1]) {
            result[1] = v[1][1];
        } else if (v[1][1] == v[2][1]) {
            result[1] = v[0][1];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 4}, {3, 4}, {3, 10}})));
    }
}
