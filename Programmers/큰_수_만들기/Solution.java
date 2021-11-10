package 큰_수_만들기;

class Solution {

    public String solution(String number, int k) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            int inputInt = Integer.parseInt(String.valueOf(ch));

            while (ans.length() > 0 && k > 0) {
                if (inputInt <= Integer.parseInt(String.valueOf(ans.charAt(ans.length() - 1)))) {
                    break;
                }
                ans.deleteCharAt(ans.length() - 1);
                k--;
            }
            ans.append(ch);
        }

        return ans.substring(0, ans.length() - k);
    }
}