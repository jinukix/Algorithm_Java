package _2개_이하로_다른_비트;

class Solution {

    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if (num % 2 == 0) {
                result[i] = num + 1;
                continue;
            }

            String binaryString = Long.toBinaryString(numbers[i]);

            if (!binaryString.contains("0")) {
                binaryString = binaryString.replaceFirst("1", "10");
            } else {
                int ZeroIdx = binaryString.lastIndexOf("0");
                int OneIdx = binaryString.substring(ZeroIdx).indexOf("1") + ZeroIdx;

                binaryString = binaryString.substring(0, ZeroIdx) + "1"
                    + binaryString.substring(ZeroIdx + 1, OneIdx) + "0"
                    + binaryString.substring(OneIdx + 1);
            }

            result[i] = Long.parseLong(binaryString.toString(), 2);
        }

        return result;
    }
}