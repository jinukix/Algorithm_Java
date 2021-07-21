package 두_정수_사이의_합;

class Solution {
    public long solution(int a, int b) {
        if (a>b) {
            int temp = a;
            a = b;
            b = temp;
        }

        long ans = 0;
        for (int i = a; i <= b; i++) {
            ans+=i;
        }
        return ans;
    }
}