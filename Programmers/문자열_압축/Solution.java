package 문자열_압축;

class Solution {
    public int solution(String s) {
        if (s.length()==1) return 1;

        int result = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length()/2+1; i++) {
            int count = 1;
            String tempStr = s.substring(0, i);

            for (int j = i; j < s.length(); j+=i) {
                String compareStr = s.substring(j, Math.min(j + i, s.length()));

                if (compareStr.equals(tempStr)) {
                    count++;
                } else {
                    if (count==1) {
                        sb.append(tempStr);
                    } else {
                        sb.append(count).append(tempStr);
                    }

                    tempStr = compareStr;
                    count = 1;
                }
            }

            if (count==1) {
                sb.append(tempStr);
            } else {
                sb.append(count).append(tempStr);
            }

            if (result > sb.length()) result = sb.length();
            sb.delete(0, sb.length());
        }
        return result;
    }
}