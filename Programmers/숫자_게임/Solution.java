package 숫자_게임;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        int result = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx = B.length-1;
        for (int i = A.length-1; i >= 0; i--) {
            if (B[idx] > A[i]) {
                result++;
                idx--;
            }
        }

        return result;
    }
}
