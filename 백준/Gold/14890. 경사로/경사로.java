import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;
    static int[][] map;

    static boolean go(int x, boolean garo) {
        int h = 0;
        boolean[] vis = new boolean[N];

        if (garo) {
            h = map[x][0];
            for (int i = 1; i < N; i++) {
                int target = map[x][i];

                if (target == h) continue;
                if (target - h > 1 || h - target > 1) return false;

                if (target - h == 1) {
                    if (i - L < 0) return false;
                    for (int j = i - 1; j >= i - L; j--) {
                        if (map[x][j] != h || vis[j]) return false;
                        vis[j] = true;
                    }
                    h++;
                } else {
                    if (i + L > N) return false;
                    for (int j = i; j < i + L; j++) {
                        if (map[x][j] != h - 1 || vis[j]) return false;
                        vis[j] = true;
                    }
                    h--;
                    i += L - 1;
                }
            }

        } else {
            h = map[0][x];
            for (int i = 1; i < N; i++) {
                int target = map[i][x];

                if (target == h) continue;
                if (target - h > 1 || h - target > 1) return false;

                if (target - h == 1) {
                    if (i - L < 0) return false;
                    for (int j = i - 1; j >= i - L; j--) {
                        if (map[j][x] != h || vis[j]) return false;
                        vis[j] = true;
                    }
                    h++;
                } else {
                    if (i + L > N) return false;
                    for (int j = i; j < i + L; j++) {
                        if (map[j][x] != h - 1 || vis[j]) return false;
                        vis[j] = true;
                    }
                    h--;
                    i += L - 1;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (go(i, true)) cnt++;
            if (go(i, false)) cnt++;
        }
        System.out.println(cnt);
    }
}