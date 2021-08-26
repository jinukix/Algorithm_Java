package 단속카메라;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(routes));
        arrayList.sort((a, b) -> a[1] - b[1]);

        int end = Integer.MIN_VALUE;
        int result = 0;
        for (int[] temp : arrayList) {
            if (end < temp[0]) {
                result++;
                end = temp[1];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] routes = {
                {-20,15}, {-14,-5}, {-18,-13}, {-5,-3}
        };
        System.out.println(sol.solution(routes));
    }
}
