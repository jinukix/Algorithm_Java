package 나누어_덜어지는_숫자_병;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n : arr) {
            if(n%divisor==0) {
                arrayList.add(n);
            }
        }

        if (arrayList.size() == 0) {
            return new int[] {-1};
        }

        int[] ans = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i);
        }

        Arrays.sort(ans);
        return ans;
    }
}
