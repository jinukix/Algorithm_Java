package 콜라츠_추측;

class Solution {

    public int solution(long num) {
        int cnt = 0;
        while (num != 1) {
            if (cnt >= 500) {
                cnt = -1;
                break;
            }
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num *= 3;
                num++;
            }

            System.out.println(num);
            cnt++;
        }
        return cnt;
    }
}