package _124_나라의_숫자;

class Solution {
    public String solution(int n) {
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            n-=1;
            int r = n % 3;
            n = n / 3;


            ans.insert(0, "124".charAt(r));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        int x = 1;
    }
}