package 같은_숫자는_싫어;

import java.util.*;

public class Solution {

    public int[] solution(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        int prevNumber = 10;
        for (int i : arr) {
            if (prevNumber != i) {
                arrayList.add(i);
                prevNumber = i;
            }
        }

        int[] ans = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i);
        }

        return ans;
    }
}