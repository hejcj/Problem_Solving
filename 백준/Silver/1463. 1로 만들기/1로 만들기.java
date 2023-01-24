import java.io.*;

public class Main {
    public static int third(int n, int count) {

        if (n <= 1) {
            return count;
        }
        return Math.min(third(n / 2, count + 1 + n % 2), third(n / 3, count + 1 + n % 3));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int result = third(n, 0);
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}