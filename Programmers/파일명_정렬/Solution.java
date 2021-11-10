package 파일명_정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public String[] solution(String[] files) {
        Comparator<String> f = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String header1 = o1.split("[0-9]{1,5}")[0].toLowerCase();
                String header2 = o2.split("[0-9]{1,5}")[0].toLowerCase();

                if (header1.equals(header2)) {
                    Pattern pattern = Pattern.compile("[0-9]{1,5}");
                    Matcher matcher1 = pattern.matcher(o1);
                    Matcher matcher2 = pattern.matcher(o2);

                    if (matcher1.find() && matcher2.find()) {
                        return Integer.compare(Integer.parseInt(matcher1.group()),
                            Integer.parseInt(matcher2.group()));
                    }
                }
                return CharSequence.compare(header1, header2);
            }
        };

        Arrays.sort(files, f);
        return files;
    }
}