import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 남학생 배수
        // 여학생 좌우대칭이면서 가장많은 스위치를 포함하는 구간을 찾아서
        // 좌우 스위치 상태가 같아야 함
        // 스위치 boolean
        // for 문으로 N이상 지속되진 않음
        // dx + - 로 같으면 바꿔나가기
        // -dx < 0 +dx > N 거나 좌우가 다르면 break
        
        // 남학생1
        // 여학생2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] s = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if(Integer.parseInt(st.nextToken())==1) s[i] = true;
        }

        int sn = Integer.parseInt(br.readLine());
        for (int i = 0; i < sn; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st2.nextToken());
            int num = Integer.parseInt(st2.nextToken());

            // 남학생
            if (g == 1) {
                for (int j = num; j <= N; j += num) {
                    s[j] = !s[j];
                }
            }
            // 여학생
            else {
                s[num] = !s[num];
                for (int j = 1; j < N; j++) {
                    int dx = num + j;
                    int dy = num - j;
                    if (dx <= N && dy > 0) {

                        if (s[dx] == s[dy]) {
                            s[dx] = !s[dx];
                            s[dy] = !s[dy];
                        } else break;
                    } else break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(s[i]) sb.append(1).append(" ");
            else sb.append(0).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}