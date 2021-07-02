package 핸드폰_번호_가리기;

public class Solution {
    public String solution(String phone_number) {
        int l = phone_number.length();
        return  "*".repeat(l-4) + phone_number.substring(l-4, l);
    }
}
