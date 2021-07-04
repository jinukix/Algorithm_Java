package 이상한_문자_만들기;


class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] strs = s.split(" ", -1);
        StringBuffer sb = new StringBuffer();
        for (String str: strs) {
            if (str.equals("")) continue;

            for (int i = 0; i < str.length(); i++) {
                if (i%2 == 0) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(str.charAt(i)));
                }
            }

            sb.append(" ");
        }

        return sb.substring(0, sb.length()-1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("asd qwer qlwdmqwkld, qwdklm  x x x a"));
    }
}
