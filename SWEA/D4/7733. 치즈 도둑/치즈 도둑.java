import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    // 치즈 길이
    static int N;

    // 치즈 맵
    static int[][] map;

    // BFS 실행할 queue
    static Queue<int[]> queue;

    // 최대값
    static int max;

    // 4방향 탐색
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 방문 배열
    static boolean[][] dist;

    static void bfs(int X) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N) continue;
                if(dist[x][y] || map[x][y] <= X) continue;

                queue.offer(new int[]{x, y});
                dist[x][y] = true;
            }
        }
    }

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        //출력
        StringBuilder sb = new StringBuilder();

        // TC
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            // 치즈 길이
            N = sc.nextInt();

            // 치즈 맵 생성
            map = new int[N][N];

            max = 1;

            int X = 0;
            // 치즈 맵 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    X = Math.max(X, map[i][j]);
                }
            }

            // 1~X날 까지 반복
            // X날이 되면 모든 치즈를 다 먹었을 것이기 때문에
            for (int i = 1; i < X; i++) {

                // 개수 세기
                int cnt = 0;
                // 방문배열 초기화
                dist = new boolean[N][N];
                // 큐 초기화
                queue = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        // 치즈를 아직 안먹었고 덩어리 판단을 안했다면
                        if (map[j][k] > i && !dist[j][k]) {
                            cnt++;
                            queue.offer(new int[]{j, k});
                            dist[j][k] = true;
                            bfs(i);
                        }
                    }
                }

                max = Math.max(max, cnt);
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);

    }
}