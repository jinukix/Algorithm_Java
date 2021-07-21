package 행렬의_덧셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] ans = {};
        ans = arr1;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                ans[i][j] += arr2[i][j];
            }
        }
        return ans;
    }
}