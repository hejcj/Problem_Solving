import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] pick;
    static String[] same = new String[(int)Math.pow(2,8)+1];
    static int cnt = 0;
    static void recur(int n) {
        if (n == M) {

            StringBuilder sb2 = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if (pick[i]) {
                    sb2.append(i).append(" ");
                }
            }

            for (int i = 0; i < cnt; i++) {
                if(String.valueOf(sb2).equals(same[i])) return;
            }
            same[cnt] = String.valueOf(sb2);
            cnt++;

            sb.append(sb2);
            sb.append("\n");

            return;
        }

        for (int i = n + 1; i <= N; i++) {
            if(pick[i]) continue;
            pick[i] = true;
            recur(n + 1);
            pick[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // 수열은 오름차순
        // 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pick = new boolean[N + 1];

        recur(0);
        System.out.println(sb);
    }
}