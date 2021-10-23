public class BinaryConversion {
    public static void main(String[] args) {
        conversion(111123, 2);
    }

    public static void conversion(int number, int N){
        StringBuilder sb = new StringBuilder();

        while (number > 0){
            if (number % N < 10){
                sb.append(number % N);
            } else {
                sb.append((char)(number % N - 10 + 'A'));
            }
            number /= N;
        }

        System.out.println(sb.reverse());
    }
}
