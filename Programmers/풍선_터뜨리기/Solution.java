package 풍선_터뜨리기;

class Solution {

    public int solution(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int[] rightIdx = new int[arr.length];
        int minLeft = arr[0];

        int n = arr[arr.length - 1];
        for (int i = arr.length - 2; i > 0; i--) {
            if (n > arr[i]) {
                n = arr[i];
            }
            rightIdx[i] = n;
        }

        int result = 2;
        for (int i = 1; i < arr.length - 1; i++) {
            if (minLeft < arr[i] && rightIdx[i] < arr[i]) {
                continue;
            }
            if (minLeft > arr[i]) {
                minLeft = arr[i];
            }

            result++;
        }

        return result;
    }
}