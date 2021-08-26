package 괄호_변환;

class Solution {
    public boolean checkBracket(String s, boolean isProper){
        int count = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;

                if (isProper && count<0) return false;
            }
        }

        return count==0;
    }

    public void translateBracket(String s, StringBuilder sb) {
        for (int i = 1; i <= s.length(); i++) {
            String u = s.substring(0, i);
            if (checkBracket(u, false)) {
                if (checkBracket(u, true)) {
                    sb.append(u);
                    translateBracket(s.substring(i), sb);
                } else {
                    StringBuilder newSb = new StringBuilder();

                    translateBracket(s.substring(i), newSb);
                    newSb.insert(0, '(');
                    newSb.append(')');

                    u = u.substring(1, u.length()-1);
                    u = u.replaceAll("[(]", "t")
                            .replaceAll("[)]", "(")
                            .replaceAll("t", ")");

                    newSb.append(u);
                    sb.append(newSb);
                }
                return;
            }
        }
    }

    public String solution(String p) {
        if (p.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        translateBracket(p, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("()))((()");
    }
}