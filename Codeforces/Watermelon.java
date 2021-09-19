import java.io.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String result = (n % 2 == 0 && n != 2) ? "YES" : "NO";
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
