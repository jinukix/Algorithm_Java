package 숫자_문자열과_영단어;

class Solution {
    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < strArr.length; i++) {
            if (s.contains(strArr[i]))
                s = s.replaceAll(strArr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}