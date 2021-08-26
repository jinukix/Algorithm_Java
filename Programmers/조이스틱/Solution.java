package 조이스틱;

import java.util.Arrays;

class Solution {
    public int solution(String name) {
        char[] names = name.toCharArray();
        char[] chars = new char[name.length()];
        Arrays.fill(chars, 'A');

        int left, right;
        int leftIdx, rightIdx;

        int result = 0;
        int currentIdx = 0;
        if (names[0]!='A') result = Integer.min(names[0]-'A', 'A'-names[0]+26);
        names[0] = 'A';

        while (!Arrays.equals(names, chars)) {
            leftIdx = currentIdx;
            rightIdx = currentIdx;

            for (left = 1; left <= names.length; left++) {
                leftIdx--;
                if (leftIdx==-1) leftIdx=names.length-1;
                if (names[leftIdx] != 'A') break;
            }

            for (right = 1; right <= names.length; right++) {
                rightIdx++;
                if (rightIdx==names.length) rightIdx=0;
                if (names[rightIdx] != 'A') break;
            }

            if (left < right) {
                result += left;
                currentIdx = leftIdx;
            } else {
                result += right;
                currentIdx = rightIdx;
            }

            result += Integer.min(names[currentIdx]-'A', 'A'-names[currentIdx]+26);
            names[currentIdx] = 'A';
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("JEROEN");
    }
}