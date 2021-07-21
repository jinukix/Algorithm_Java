package 다음_큰_숫자;

class Solution {
    private int getBinaryOneCount(int num){
        String binaryString = Integer.toBinaryString(num);
        int cnt = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                cnt++;
            }
        }

        return cnt;
    }
    public int solution(int n) {
        int cnt = getBinaryOneCount(n);

        while (true) {
            n++;

            if (cnt == getBinaryOneCount(n)){
                break;
            }
        }

        return n;
    }
}