package 소수_찾기2;

import java.util.HashSet;

public class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int ans = 0;

        for (Integer integer : set) {
            if (isPrime(integer)) ans++;
        }

        return ans;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));

        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    public boolean isPrime(int n) {
        if (n<2) return false;

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n%i==0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("123456"));
    }
}
