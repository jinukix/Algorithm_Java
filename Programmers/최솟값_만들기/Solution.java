package 최솟값_만들기;

import java.util.Arrays;

class Solution
{
    public int solution(int []arr1, int []arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans = 0;

        for (int i = 0; i < arr1.length; i++) {
            ans += arr1[i] * arr2[arr2.length-i-1];
        }

        return ans;
    }
}