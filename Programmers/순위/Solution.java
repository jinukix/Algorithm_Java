package 순위;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        final int INF = 101;
        int[][] fw = new int[n+1][n+1];

        for (int[] arr : fw) {
            Arrays.fill(arr, INF);
        }

        for (int[] arr : results) {
            fw[arr[0]][arr[1]] = 1;
        }

        for (int k = 1; k < fw.length; k++) {
            for (int i = 1; i < fw.length; i++) {
                for (int j = 1; j < fw.length; j++) {
                    fw[i][j] = Math.min(fw[i][j], fw[i][k] + fw[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i < fw.length; i++) {
            boolean flag = true;
            for (int j = 1; j < fw[i].length; j++) {
                if (i == j) continue;

                if (fw[i][j] == INF && fw[j][i] == INF) {
                    flag = false;
                    break;
                }
            }

            if (flag) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
            5,
        new int[][] {{4,3},{4,2},{3,2},{2,5},{1,2}}
        ));
    }
}