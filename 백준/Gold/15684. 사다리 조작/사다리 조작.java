import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int H;
    static boolean[][] map;
    static boolean isEnd = false;

    static boolean ladder() {
        for (int i = 1; i <= N; i++) {
            int point = i;
            for (int j = 1; j <= H; j++) {
                if (map[j][point]) point++;
                else if (map[j][point - 1]) point--;
            }
            if (point != i) return false;
        }
        return true;
    }

    static void recur(int n, int c, int idx) {

        if (isEnd) return;



        if (n == c) {
            if (ladder()) {
                isEnd = true;
            }
            return;
        }

        if(idx >= H*N + N) return;

        // 가로선이 연속되면 안된다.
        int x = idx / N;
        int y = idx % N;

        // 선택 한다
        if (idx % N != 0 && !map[x][y] && !map[x][y - 1] && !map[x][y + 1]) {
            map[x][y] = true;
            recur(n, c + 1, idx + 1);
            map[x][y] = false;
        }
        // 선택 안한다.
        recur(n, c, idx + 1);
    }

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < 4; i++) {
            recur(i, 0, N + 1);
            if (isEnd) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}