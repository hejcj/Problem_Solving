import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 어느 사다리를 고르면 X에 도착하는가?
        // 한줄입력받고
        // index 저장중
        // 오른쪽이나 왼쪽있으면 그쪽으로 index 이동 while 없을때까지
        // 없으면 한줄입력받고, index y++
        // 반대로 사다리를 타자
        // 모두 입력받고
        // 위로 올라가쟈
        // y ==0 될때까지
        // 시작 y = 99
        // 100, 100 배열
        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            int[][] ladder = new int[100][102];
            for (int j = 0; j < 100; j++) {
                for (int k = 1; k <= 100; k++) {
                    ladder[j][k] = sc.nextInt();
                }
            }
            // 초기 index 찾기
            int x = 99;
            int y = 1;
            for (int j = 1; j <= 100; j++) {
                if(ladder[x][j] == 2) {
                    y = j;
                    break;
                }
            }

            // 도착
            while (x > 0) {
                // 좌 우 먼저 탐색

                int temp = y;
                //좌
                while (ladder[x][y - 1] == 1) {
                    y--;
                    ladder[x][y] = 0;
                }



                //우
                while (ladder[x][y + 1] == 1) {
                    y++;
                    ladder[x][y] = 0;
                }
                //위로
                if(temp == y) x--;
            }
            System.out.printf("#%d %d\n", n, y-1);
        }
    }
}