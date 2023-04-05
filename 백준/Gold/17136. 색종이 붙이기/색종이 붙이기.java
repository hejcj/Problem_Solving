import java.util.Scanner;

public class Main {
    // 1*1에 1을 붙이기 2를 붙이기 3을 붙이기 4를 붙이기 5를 붙이기
    // 1을 붙였다면
    // 진행 되는 xy가 x+2 % 5
    // 맵
    static boolean[][] map = new boolean[10][10];
    // 최솟값
    static int min = Integer.MAX_VALUE;
    static int aa = 0;

    // 색종이 개수
    static int[] pQ = {0, 5, 5, 5, 5, 5};
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
            // 1붙이기
            if (pQ[1] > 0) {
                aa--;
                cMap(x, y, 1, false);
                pQ[1]--;
                dfs(n + 1, cnt + 1);
                pQ[1]++;
                cMap(x, y, 1, true);
                aa++;
            }

            // 2붙이기

            if (isOk(x, y, 2) && pQ[2] > 0) {
                aa -= 4;
                cMap(x, y, 2, false);
                pQ[2]--;
                dfs(n + 1, cnt + 1);
                cMap(x, y, 2, true);
                pQ[2]++;
                aa += 4;
            }

            // 3붙이기

            if (isOk(x, y, 3) && pQ[3] > 0) {

                aa -= 9;
                cMap(x, y, 3, false);
                pQ[3]--;
                dfs(n + 1, cnt + 1);
                cMap(x, y, 3, true);
                pQ[3]++;
                aa += 9;
            }

            // 4붙이기
            if (isOk(x, y, 4) && pQ[4] > 0) {
                aa -= 16;
                cMap(x, y, 4, false);
                pQ[4]--;
                dfs(n + 1, cnt + 1);
                cMap(x, y, 4, true);
                pQ[4]++;
                aa += 16;
            }


            // 5붙이기
            if (isOk(x, y, 5) && pQ[5] > 0) {
                aa -= 25;
                cMap(x, y, 5, false);
                pQ[5]--;
                dfs(n + 1, cnt + 1);
                cMap(x, y, 5, true);
                pQ[5]++;
                aa += 25;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (sc.next().equals("1")) {
                    map[i][j] = true;
                    aa++;
                }
            }
        }
        dfs(0, 0);
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}