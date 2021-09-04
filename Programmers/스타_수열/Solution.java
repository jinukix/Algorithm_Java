package 스타_수열;

public class Solution {
    public int solution(int[] a) {
        int result = 0;

        int[] countArr = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            countArr[a[i]]++;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] * 2 <= result) continue;
            int star = 0;

            for (int j = 0; j < a.length-1; j++) {
                if (((a[j] == i) || a[j+1] == i) && (a[j] != a[j+1])) {
                    star+=2;
                    j++;
                }
            }
            result = Integer.max(result, star);
        }
        return result;
    }
}
