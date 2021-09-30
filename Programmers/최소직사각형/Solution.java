package 최소직사각형;

class Solution {
    public int solution(int[][] sizes) {
        int r = 0;
        int c = 0;
        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            r = Math.max(max, r);
            c = Math.max(min, c);
        }

        return r * c;
    }
}