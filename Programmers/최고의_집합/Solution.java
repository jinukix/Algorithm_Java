package 최고의_집합;

class Solution {
    public int[] solution(int n, int s) {
        if (n>s) return new int[] {-1};

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = s/n;
        }

        for (int i = 0; i < s%n; i++) {
            result[n-1-i]++;
        }

        return result;
    }
}
