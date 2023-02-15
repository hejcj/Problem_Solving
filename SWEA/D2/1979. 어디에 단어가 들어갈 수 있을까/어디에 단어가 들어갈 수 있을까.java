import java.util.Scanner;

public class Solution {
    /*
     * 길이가 n인 단어가 들어갈 수 있는 곳 숫자 찾기
     * 2차원 배열 상하 좌우 탐색?
     *
     * 상하 좌우로 뻗어나간다.
     * 포문을 돌면서
     * 만약 검정색이라면
     * 상하좌우로 계속 탐색 탐색된 곳은 1로 바꾸기
     * 그렇다면 오른쪽과 아래쪽으로만 탐색해나가면됨
     *
     * 문제를 잘못 이해했다. 단어 퍼즐
     *
     * 1인 부분에 직선 가로 혹은 직선 세로로 들어갈 수 있는 위치를 찾는 것
     *
     * 만약 1이라면 오른쪽 아래쪽으로만 탐색 정확하게 K랑 일치해야함
     *
     * for 문 돌면서
     * 만약 오른쪽으로 while 0을 만날 때 까지
     * 아래쪽을 while 0을 만날 때 까지
     *
     * 길이가 k와 같으면 cnt ++
     *
     * 알고리즘
     * 자료구조
     *
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] puzzle = new int[N][N];

            int cnt = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    puzzle[j][k] = sc.nextInt();
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (puzzle[j][k] == 1) {
                        // 가로 탐색
                        int l = 1;
                        int y = k;

                        // 오른쪽 탐색
                        while (++y < N) {
                            if (puzzle[j][y] == 1) l++;
                            else break;
                        }
                        // 왼쪽 탐색
                        if(K == l) {
                            if(k <1) cnt++;
                            else {
                                if(puzzle[j][k-1] == 0) cnt++;
                            }
                        }

                        // 세로 탐색
                        l = 1;
                        int x = j;

                        // 아래 탐색
                        while (++x < N) {
                            if (puzzle[x][k] == 1) l++;
                            else break;
                        }

                        // 위 탐색
                        if(K == l) {
                            if(j <1) cnt++;
                            else {
                                if(puzzle[j-1][k] == 0) cnt++;
                            }
                        }

                    }
                }
            }
            System.out.printf("#%d %d\n",i+1,cnt);
        }
    }
}
