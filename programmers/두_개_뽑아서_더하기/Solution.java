package 두_개_뽑아서_더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];

                if (!arr.contains(num)) {
                    arr.add(num);
                }
            }
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
}