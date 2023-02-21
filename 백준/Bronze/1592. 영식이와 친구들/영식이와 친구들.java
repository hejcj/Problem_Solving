import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 2 3 4 5
        // 3 2 2 2 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] ball = new int[N + 1];
        ball[1] = 0;
        int idx = 1;
        int cnt = 0;
        while (++ball[idx] < M) {
            if (ball[idx] % 2 == 1) {
                idx += L;
                idx %= N;
                if(idx == 0) idx = N;
            } else {
                idx -= L;
                if (idx <= 0) {
                    idx += N;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}