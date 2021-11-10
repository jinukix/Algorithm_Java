package 평균_구하기;

class Solution {

    public double solution(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum / (double) arr.length;
    }
}