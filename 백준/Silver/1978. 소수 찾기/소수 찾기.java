import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        boolean[] is_prime = new boolean[1001];
        Arrays.fill(is_prime, true);
        is_prime[0] = false;
        is_prime[1] = false;

            for (int j = 2; j <= 1000; j++) {
                if (is_prime[j]) {
                    for (int i = j+j; i <= 1000; i+=j) {
                        is_prime[i] = false;
                    }
                }
            }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int a = Integer.parseInt(st.nextToken());
            if(is_prime[a]) cnt++;
        }
        System.out.println(cnt);
    }
}
