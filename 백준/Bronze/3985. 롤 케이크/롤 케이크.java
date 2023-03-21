import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 길이 L 롤 케이크
        // N명에게 케이크를 나누어 주려고 한다.
        // 1~ N 번
        // 각 방청객은 종이에 자신이 원하는 조각을 적어서 낸다.
        // 이때 두수 P와 K를 적어서 내며, P번 조각부터 K번 조각을 원한다는 뜻이다.

        // P - K +1 가 가장 큰 사람 출력
        // boolean 배열 탐색하여 false 이면 true로 바꾸고 false 개수가 가장 큰 사람 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int epMax = 0;
        int realMax = 0;
        int epMaxCnt = 0;
        int realMaxCnt = 0;

        boolean[] isPick = new boolean[L + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if (epMaxCnt < K - P + 1) {
                epMaxCnt = K - P + 1;
                epMax = i + 1;
            }
            int tmepCnt = 0;
            for (int j = P; j <= K; j++) {
                if(isPick[j]) continue;
                tmepCnt++;
                isPick[j] = true;
            }

            if(tmepCnt > realMaxCnt) {
                realMaxCnt = tmepCnt;
                realMax = i  +1;
            }
        }
        System.out.println(epMax);
        System.out.println(realMax);
    }
}