package _3진법_뒤집기;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append(n % 3);
            n/=3;
        }

        String str = sb.toString();
        return Integer.parseInt(str, 3);

//        int ans = 0;
//        int multi = 1;
//        String str = sb.toString();
//
//        for (int i = str.length()-1; i >= 0; i--) {
//            ans += ((int)str.charAt(i) - '0') * multi;
//            multi *= 3;
//        }
//
//        return ans;
    }
}