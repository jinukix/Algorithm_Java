package N진수_게임;

class Solution {

    public String solution(int n, int t, int m, int p) {
        StringBuilder convertSB = new StringBuilder();
        convertSB.append('0');

        int count = ((t - 1) * m) + p;
        int num = 1;
        while (convertSB.length() < count) {
            String str = conversion(num, n);
            convertSB.append(str);
            num++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int idx = (m * i) + p - 1;
            ans.append(convertSB.charAt(idx));
        }

        return ans.toString();
    }

    public static String conversion(int num, int n) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            char ch = "0123456789ABCDEF".charAt(num % n);
            sb.insert(0, ch);
            num /= n;
        }

        return sb.toString();
    }
}