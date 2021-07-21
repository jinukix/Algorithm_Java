package 신규_아이디_추천;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();

        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$","");

        if (new_id.equals("")) {
            new_id = "a";
        } else if (new_id.length()>=16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^[.]|[.]$","");
        }

        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length()-1);
        }

        return new_id;

//        for (int i = 0; i < new_id.length(); i++) {
//            char ch = new_id.charAt(i);
//
//            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || ch=='_' || ch=='-') {
//                sb.append(ch);
//            }
//
//            if (ch == '.' && sb.length()!=0  && sb.charAt(sb.length()-1) != '.') {
//                sb.append(ch);
//            }
//        }
//
//        if (sb.length() !=0 && sb.charAt(sb.length()-1) == '.') {
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//        String str = sb.toString();
//        if (str.length() == 0) {
//            str = "a";
//        } else if (str.length() >= 16) {
//            str = str.substring(0,15);
//
//            if (str.charAt(str.length()-1) == '.') {
//                str = str.substring(0, 14) ;
//            }
//        }
//
//        while (str.length() <= 2) {
//            str += str.charAt(str.length()-1);
//        }
//
//        return str;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("=.="	));
    }
}