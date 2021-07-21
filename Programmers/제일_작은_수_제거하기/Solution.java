package 제일_작은_수_제거하기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        Integer min = Collections.min(arrList);
        arrList.remove(min);
        int[] ans = new int[arrList.size()];

        for (int i = 0; i < arrList.size(); i++) {
            ans[i] = arrList.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4};
        System.out.println(sol.solution(arr));
    }
}