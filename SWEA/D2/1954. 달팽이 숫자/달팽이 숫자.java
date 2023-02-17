import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 오른쪽 끝에 다다르면 아래로
        // 아래쪽 끝에 다다르면 왼쪽으로
        // 왼쪽끝에 다다르면 위쪾으로
        // 위쪽 끝에 다다르면 오른쪽으로
        // 0,0 시작
        // N,N배열 만들어서 출력 하기

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            sb.append("#").append(i + 1).append("\n");
            int N = sc.nextInt();
            int cnt = 1;
            int[][] snail = new int[N][N];
            int x = 0;
            int y = 0;
            snail[0][0] = 1;
            int direction = 0;
            // 0 오른쪽 1 아래쪽 2 왼쪽 3 위쪽
            while (cnt < N * N) {

                if (direction == 0) {
                    if (y + 1 < N && snail[x][y + 1] == 0) {
                        snail[x][++y] = ++cnt;
                    } else {
                        direction = 1;
                    }
                } else if (direction == 1 ) {
                    if (x + 1 < N && snail[x + 1][y] == 0) {
                        snail[++x][y] = ++cnt;
                    } else {
                        direction = 2;
                    }
                } else if (direction == 2 ) {
                    if (y - 1 >= 0 && snail[x][y - 1] == 0) {
                        snail[x][--y] = ++cnt;
                    } else {
                        direction = 3;
                    }
                } else {
                    if (x - 1 >= 0 && snail[x - 1][y] == 0) {
                        snail[--x][y] = ++cnt;
                    } else {
                        direction = 0;
                    }
                }

            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(snail[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
