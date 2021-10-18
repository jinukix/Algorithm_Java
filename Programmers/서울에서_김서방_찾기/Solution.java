package 서울에서_김서방_찾기;

import java.util.Arrays;

class Solution {
    public String solution(String[] seoul) {
        int idx = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + idx + "에 있다";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] seoul = {"Kim", "qwe.text", "넷웟.text"};
        System.out.println(sol.solution(seoul));
    }
}