package k번쨰수;

import java.util.Arrays;

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            ans[i] = arr[commands[i][2] - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }
}