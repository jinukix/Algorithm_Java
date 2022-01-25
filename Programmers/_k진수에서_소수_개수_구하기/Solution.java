package _k진수에서_소수_개수_구하기;

class Solution {

    StringBuilder sb = new StringBuilder();

    public int solution(int n, int k) {
        char[] chars = conversion(n, k).toCharArray();
        sb.setLength(0);

        int result = 0;
        for (char ch : chars) {
            if (ch == '0') {
                result += isPrimary();
            } else {
                sb.append(ch);
            }
        }

        result += isPrimary();
        return result;
    }

    public int isPrimary() {
        if (sb.length() == 0) {
            return 0;
        }

        long l = Long.parseLong(sb.toString());
        if (l < 2) {
            return 0;
        }

        sb.setLength(0);
        for (int i = 2; i <= Math.sqrt(l); i++) {
            if (l % i == 0) {
                return 0;
            }
        }

        return 1;
    }

    public String conversion(int number, int N) {
        while (number > 0) {
            if (number % N < 10) {
                sb.append(number % N);
            } else {
                sb.append((char) (number % N - 10 + 'A'));
            }
            number /= N;
        }
        return sb.reverse().toString();
    }
}