package 같은_숫자는_싫어;

import java.util.ArrayList;

public class Solution {

    public int[] solution(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        int prevNumber = 10;
        for (int n : arr) {
            if (prevNumber != n) {
                arrayList.add(n);
                prevNumber = n;
            }
        }

        int[] ans = arrayList.stream().mapToInt(n -> n).toArray();

        return ans;
    }
}