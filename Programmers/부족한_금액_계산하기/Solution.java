package 부족한_금액_계산하기;

public class Solution {
    public long solution(int price, int money, int count) {
        long result = money;

        for (int i = 1; i < count+1; i++) {
            result -= (long) price * i;
        }

        return (result > 0 ? 0 : -result);
    }
}
