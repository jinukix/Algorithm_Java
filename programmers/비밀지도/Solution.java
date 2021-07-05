package 비밀지도;

import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder arr1Sb = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder arr2Sb = new StringBuilder(Integer.toBinaryString(arr2[i]));

            while (arr1Sb.length() != n) {
                arr1Sb.insert(0, "0");
            }

            while (arr2Sb.length() != n) {
                arr2Sb.insert(0, "0");
            }

            StringBuilder ansSb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (arr1Sb.charAt(j) == '1' || arr2Sb.charAt(j) == '1') {
                    ansSb.append("#");
                } else {
                    ansSb.append(" ");
                }
            }

            ans[i] = ansSb.toString();
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {9, 20, 28, 18, 1};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution.solution(5, arr1, arr2)));
    }
}
