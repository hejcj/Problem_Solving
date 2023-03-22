import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 색종이 비슷하게 놓이면

        // 색종이가 보이는 부분의 면적을 구하는 프로그램 작성

        // 색종이가 놓이는 평면은 가로 1001칸 세로 최대 1001칸

        int[][] map = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x1 +w; j++) {
                for (int k = y1; k < y1 + h; k++) {
                    map[k][j] = i;
                }
            }
        }

        int[] cnt = new int[N+1];

        for (int j = 0; j < 1001; j++) {
            for (int k = 0; k < 1001; k++) {
                cnt[map[k][j]]++;
            }
        }
        for (int j = 1; j <= N; j++) {
            sb.append(cnt[j]).append("\n");
        }
        System.out.println(sb);
    }
}