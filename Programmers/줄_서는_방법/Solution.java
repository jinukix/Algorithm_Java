package 줄_서는_방법;

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        long permutationCount = 1;
        for (int i = 1; i < n; i++) {
            arrayList.add(i);
            permutationCount*=i;
        }
        arrayList.add(n);

        int[] result = new int[n];
        int idx = 0;
        k--;
        n--;

        while (!arrayList.isEmpty()) {
            int x = (int)(k/permutationCount);

            k%=permutationCount;
            permutationCount/=n;
            if (n!=1) n--;

            result[idx] = arrayList.get(x);
            arrayList.remove((Integer) result[idx++]);
        }

        return result;
    }
}