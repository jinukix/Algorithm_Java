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

            String binaryString = Long.toBinaryString(num);

            if (!binaryString.contains("0")) {
                binaryString = binaryString.replaceFirst("1", "10");
            } else {
                int zeroIdx = binaryString.lastIndexOf("0");
                int oneIdx = binaryString.substring(zeroIdx).indexOf("1") + zeroIdx;

                binaryString = binaryString.substring(0, zeroIdx) + "1"
                    + binaryString.substring(zeroIdx + 1, oneIdx) + "0"
                    + binaryString.substring(oneIdx + 1);
            }

            result[i] = Long.parseLong(binaryString, 2);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new long[]{1223});
    }
}