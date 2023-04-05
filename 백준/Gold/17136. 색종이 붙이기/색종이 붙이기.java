import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 1*1에 1을 붙이기 2를 붙이기 3을 붙이기 4를 붙이기 5를 붙이기
    // 1을 붙였다면
    // 진행 되는 xy가 x+2 % 5
    // 맵
    static boolean[][] map;
    // 최솟값
    static int min;
    static int aa;
    static int[] aa2 = {0, 1, 4, 9, 16, 25};

    // 색종이 개수
    static int[] pQ;
    // dfs


    static boolean isOk(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (i >= 10 || j >= 10 || !map[i][j]) return false;
            }
        }
        return true;
    }

    static void cMap(int x, int y, int n, boolean cc) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                map[i][j] = cc;
            }
        }
    }

    static void dfs(int n, int cnt) {

        if (cnt > min) return;

        if (n == 100) {
            if (aa == 0) {
                min = Math.min(min, cnt);
            }
            return;
        }
        int x = n / 10;
        int y = n % 10;

        if (!map[x][y]) dfs(n + 1, cnt);
        else {
            for (int i = 1; i <= 5; i++) {
                if (isOk(x, y, i) && pQ[i] > 0) {
                    aa -= aa2[i];
                    cMap(x, y, i, false);
                    pQ[i]--;
                    dfs(n + 1, cnt + 1);
                    cMap(x, y, i, true);
                    pQ[i]++;
                    aa += aa2[i];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        min = Integer.MAX_VALUE;
        pQ = new int[]{0, 5, 5, 5, 5, 5};
        map = new boolean[10][10];
        aa = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                    aa++;
                }
            }
        }
        dfs(0, 0);
        if (min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);
    }
}