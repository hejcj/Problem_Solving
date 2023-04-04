import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // 벽돌깨기!
    // 백트레킹으로 구슬 위치 떨어뜨리기
    // 벽이 깨진 것을 기록할 수 있을까?
    // 1. 구슬을 골랐을 때 깊은복사를 해야할까?
    // 2. 벽들 방문배열을 통해서 깨진 것을 false로 만들고 true로 만드는 작업을 해줄까?
    // 2번으로 선택

    // 중력이 작용해서 맵을 바꿔줘야 하는데
    // 이걸 어떻게 하지


    // 구슬 떨어뜨리는 숫자
    static int N;

    // 벽돌 맵 크기
    static int W;
    static int H;

    // 벽돌 맵
    static int[][] map;
    static int[][] map2;

    // 벽돌 깨졌을 때 맵
    static boolean[][] result;

    // 구슬 방문 배열
    static boolean[] vis;
    // 구슬 떨어뜨리는 위치를 저장
    static int[] choice;

    // 최소벽돌 개수
    static int min;

    // 벽돌깨기 델타배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    // 상하좌우로 벽돌꺠기
    static void brick(int x, int y, int n) {

        for (int j = 0; j < 4; j++) {
            int xx = x;
            int yy = y;
            for (int k = 0; k < n; k++) {
                xx += dx[j];
                yy += dy[j];
                if (xx < 0 || yy < 0 || xx >= H || yy >= W) break;
                if (map2[xx][yy] == 0) continue;
                // 벽돌 깨지고
                vis[yy] = true;
                int scale = map2[xx][yy];
                map2[xx][yy] = 0;
                if (scale == 1) continue;
                brick(xx, yy, scale - 1);
            }
        }

        return;
    }

    // 백트레킹으로 구슬 떨어뜨리는 위치 메소드

    static void bead(int n) {

        // 구슬을 N번 떨어뜨렸으면,
        if (n == N) {
            // 벽돌 떨어뜨리고
            // 벽돌깨기
            for (int i = 0; i < N; i++) {
                int x = -1;
                int y = choice[i];
                // 해당위치의 제일 위에 있는 구슬 찾기
                for (int j = 0; j < H; j++) {
                    // 벽돌 없으면 스킵
                    if (map2[j][y] == 0) continue;
                    x = j;
                    break;
                }
                // 없다면 구슬 사라짐
                if (x == -1) continue;
                int scale = map2[x][y];
                map2[x][y] = 0;
                // 벽돌 크기가 1이면 컨틴뉴
                if (scale == 1) continue;
                // 있다면, 벽돌 깨기
                brick(x, y, scale - 1);
                // 벽돌이 아래로 쌓이기
                // 중력 메소드가 중요한데...
                for (int j = 0; j < W; j++) {
                    for (int k = H - 2; k >= 0; k--) {
                        if (map2[k][j] > 0 && map2[k + 1][j] == 0) {
                            int idx = 0;
                            for (int l = k + 1; l < H; l++) {
                                if(map2[l][j] == 0) idx = l;
                            }
                            map2[idx][j] = map2[k][j];
                            map2[k][j] = 0;
                        }
                    }
                }

            }


            for (int j = 0; j < W; j++) {
                vis[j] = false;
            }
            // 벽돌 개수 세기
            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map2[i][j] > 0) cnt++;
                    // 벽돌 되돌리기
                    map2[i][j] = map[i][j];
                }
            }
            min = Math.min(min, cnt);
            return;
        }
        // 구슬 떨어뜨리는 위치 고르기
        for (int i = 0; i < W; i++) {

            // 선택배열에 넣기
            choice[n] = i;
            // 벽돌 깨기
            // DFS
            bead(n + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 입력받기
        int T = sc.nextInt();

        // 테스트케이스 순회
        for (int tc = 1; tc <= T; tc++) {
            // 최소벽돌 개수 최대값으로 초기화
            min = Integer.MAX_VALUE;
            // 구슬 숫자
            N = sc.nextInt();
            // W
            W = sc.nextInt();
            // H
            H = sc.nextInt();
            // 맵초기화
            map = new int[H][W];
            map2 = new int[H][W];

            // 깨짐여부 배열 초기화

            // 초이스 배열 초기화
            choice = new int[N];
            // 방문배열 초기화
            vis = new boolean[W];

            // 맵입력 받기
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    // 맵입력
                    // 깨짐여부입력
                    map[i][j] = sc.nextInt();
                    map2[i][j] = map[i][j];
                }
            }
            // 벽돌 깨기 시작
            bead(0);

            // 결과 입력
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}