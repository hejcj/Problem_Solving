import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int n = N;

        for (int i = 0; i < N * 2; i++) {

            if (i < N) n--;
            else n++;

            for (int j = 0; j < N - n; j++) {
                sb.append("*");
            }

            for (int j = 0; j < n * 2; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < N - n; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}