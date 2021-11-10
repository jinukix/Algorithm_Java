package 쿼드압축_후_개수_세기;

import java.util.Arrays;

class Solution {

    private final int[] ans = {0, 0};

    public int[] solution(int[][] arr) {
        comp(arr, 0, 0, arr.length);
        return ans;
    }

    public void comp(int[][] arr, int y, int x, int l) {
        int init = arr[y][x];

        for (int i = y; i < y + l; i++) {
            for (int j = x; j < x + l; j++) {
                if (arr[i][j] != init) {
                    int ll = l / 2;

                    comp(arr, y, x, ll);
                    comp(arr, y, x + ll, ll);
                    comp(arr, y + ll, x, ll);
                    comp(arr, y + ll, x + ll, ll);
                    return;
                }
            }
        }
        ans[init] += 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        System.out.println(Arrays.toString(sol.solution(arr)));
    }
}