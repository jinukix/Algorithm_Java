package 신규_아이디_추천;

public class Solution {

    public String solution(String newId) {
        newId = newId.toLowerCase()
            .replaceAll("[^-_.a-z0-9]", "")
            .replaceAll("[.]{2,}", ".")
            .replaceAll("^[.]|[.]$", "");

        if (newId.equals("")) {
            newId = "a";
        } else if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("^[.]|[.]$", "");
        }

        StringBuilder sb = new StringBuilder(newId);
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
