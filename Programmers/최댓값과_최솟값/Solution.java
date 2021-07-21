package 최댓값과_최솟값;

class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str: strs) {
            int n = Integer.parseInt(str);

            if (min > n) {
                min = n;
            }

            if (max < n) {
                max = n;
            }
        }

        return min + " " + max;
    }
}