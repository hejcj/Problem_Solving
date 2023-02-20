import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        boolean[] is_Prime = new boolean[N + 1];
        Arrays.fill(is_Prime, true);
        is_Prime[1] = false;
        is_Prime[0] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (is_Prime[i]) {
                for (int j = i + i; j <= N; j += i) {
                    is_Prime[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (is_Prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}