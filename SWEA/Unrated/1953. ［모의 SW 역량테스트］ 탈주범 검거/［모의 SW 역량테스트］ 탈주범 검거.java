import java.util.Scanner;

public class Solution {

    // 맵의 크기
    static int N;
    static int M;
    // 맵
    static int[][] map;
    // 맨홀위치
    static int R;
    static int C;

    // 소요된 시간
    static int L;
    // 방문배열 방문 하였더라도 더 빨리 도착했다면 갱신해줘야 하므로 int
    static int[][] vis;
    // 개수
    static int cnt;

    // 4방향 탐색 델타배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 절도범 위치 탐색 DFS
    static void dfs(int x, int y, int type, int time) {
        // 시간 경과
        if(time >= L) return;

        // 4방향 탐색하기
        for (int i = 0; i < 4; i++) {

            // 내가 가는 모양에 따라 갈 수 있는 곳이 정해짐 4방향
//            if(i == 0 && (type == 2 || type == 4 || type == 5 )) continue;
//            if(i == 1 && (type == 2 || type == 6 || type == 7 )) continue;
//            if(i == 2 && (type == 3 || type == 5 || type == 6 )) continue;
//            if(i == 3 && (type == 3 || type == 4 || type == 7 )) continue;
//
            // 이동할 지점
            int xx = x + dx[i];
            int yy = y + dy[i];

            // 인덱스를 벗어났다면 continue
            if(xx < 0 || yy < 0 || xx >= N || yy >= M) continue;
            // 터널이 없다면 continue
            if(map[xx][yy] == 0) continue;
            // 방문 했다면 continue & 갱신시킬수 없다면
            if(vis[xx][yy] != 0 && vis[xx][yy] <= time + 1) continue;
            // 자신의 모양과 도착할 곳 모양 비교해서 갈 수 있다면 GO
            boolean flag = false;
            int next = map[xx][yy];
            // 0은 왼쪽 1은 오른쪽 2 는 위쪽 3은 아래쪽
            switch (type) {
                // 상하좌우 모두 가능
                case 1:
                    if(i == 0 && (next == 2 || next == 6 || next == 7 )) break;
                    if(i == 1 && (next == 2 || next == 4 || next == 5 )) break;
                    if(i == 2 && (next == 3 || next == 4 || next == 7 )) break;
                    if(i == 3 && (next == 3 || next == 5 || next == 6 )) break;
                    flag = true;
                    break;
                // 상하
                case 2:

                    if(i == 0) break;
                    if(i == 1) break;
                    if(i == 2 && (next == 3 || next == 4 || next == 7 )) break;
                    if(i == 3 && (next == 3 || next == 5 || next == 6 )) break;
                    flag = true;
                    break;
                // 좌우
                case 3:
                    if(i == 0 && (next == 2 || next == 6 || next == 7 )) break;
                    if(i == 1 && (next == 2 || next == 4 || next == 5 )) break;
                    if(i == 2) break;
                    if(i == 3) break;
                    flag = true;
                    break;
                // 상우
                case 4:
                    if(i == 0) break;
                    if(i == 1 && (next == 2 || next == 4 || next == 5 )) break;
                    if(i == 2 && (next == 3 || next == 4 || next == 7 )) break;
                    if(i == 3) break;
                    flag = true;
                    break;
                // 하우
                case 5:
                    if(i == 0) break;
                    if(i == 1 && (next == 2 || next == 4 || next == 5 )) break;
                    if(i == 2) break;
                    if(i == 3 && (next == 3 || next == 5 || next == 6 )) break;
                    flag = true;
                    break;
                // 하좌
                case 6:
                    if(i == 0 && (next == 2 || next == 6 || next == 7 )) break;
                    if(i == 1) break;
                    if(i == 2) break;
                    if(i == 3 && (next == 3 || next == 5 || next == 6 )) break;
                    flag = true;
                    break;
                // 상좌
                case 7:
                    if(i == 0 && (next == 2 || next == 6 || next == 7 )) break;
                    if(i == 1) break;
                    if(i == 2 && (next == 3 || next == 4 || next == 7 )) break;
                    if(i == 3) break;
                    flag = true;
                    break;
                default:
                    break;
            }

            if (flag) {
                vis[xx][yy] = time + 1;
                dfs(xx, yy, map[xx][yy], time + 1);
            }
            // 방문처리
            // DFS 탐색
        }
    }

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        // 출력
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스
        int T = sc.nextInt();
        // 테스트 케이스 순회
        for (int tc = 1; tc < T + 1; tc++) {

            // 맵 크기 입력
            N = sc.nextInt();
            M = sc.nextInt();

            // 맵 생성
            map = new int[N][M];

            // 방문 배열 생성
            vis = new int[N][M];

            // 맨홀 위치
            R = sc.nextInt();
            C = sc.nextInt();

            // 시간
            L = sc.nextInt();


            // 맵 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            // 개수 초기화
            cnt = 0;
            // 시작 위치 방문처리
            vis[R][C] = 1;

            // 절도범위치 구하기
            dfs(R, C, map[R][C], 1);

            // 방문 배열 탐색하며 위치 개수 구하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (vis[i][j] > 0) cnt++;
                }
            }

            // 출력
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}