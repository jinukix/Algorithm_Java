package 없는_숫자_더하기;

import java.util.HashSet;

public class Solution {
    public int solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        int result = 0;
        for (int i = 0; i < 10; i++) result+=i;
        for (int number:numbers) {
            if (!set.contains(number)) {
                result-= number;
            }
            set.add(number);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[] {5,8,4,0,6,7,9});
    }
}
