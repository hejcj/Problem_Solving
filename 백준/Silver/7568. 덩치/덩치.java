import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 덩치를 키와 몸무게
        // 등수 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dung = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dung[i][0] = Integer.parseInt(st.nextToken());
            dung[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if (dung[i][0] < dung[j][0] && dung[i][1] < dung[j][1]) {
                    cnt++;
                }
            }
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }
}
