
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] map;

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    static int N;
    static int cnt = 0;

    static boolean attack(int i, int j) {

        for (int k = 0; k < dx.length; k++) {
            int x = i;
            int y = j;
            while (true) {
                x += dx[k];
                y += dy[k];
                if (x < 0 || y < 0 || x >= N || y >= N) break;
                if (map[x][y]) return true;
            }

        }
        return false;

    }

    static void recur(int qC) {
        if (qC == N) {
            cnt++;
            return;
        }


        for (int j = 0; j < N; j++) {
            if (!map[qC][j]) {

                if (!attack(qC, j)) {
                    map[qC][j] = true;
                    recur(qC + 1);
                    map[qC][j] = false;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];

        recur(0);
        System.out.println(cnt);
    }
}
