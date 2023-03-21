import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 직사각형을 만드는 방법

        // n + i = 2 <= <= Math.abs(n);
        // i <= j <= N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 2; i <= Math.abs(N); i++) {
            // 직사각형이 된다면
            for (int j = i; j <= N; j++) {
                if(i*j <= N) cnt++;
            }
        }
        System.out.println(cnt+N);
    }
}