import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int empty;
    static List<int[]> list = new ArrayList<>();
    static Queue<int[]> q;
    static int max = 0;

    // 바이러스 퍼뜨리기
    static int bfs() {
        // 안전영역 벽 3 칸 치우기
        int safe = empty - 3;
        // 방문 배열 초기화
        vis = new boolean[N][M];
        // bfs 탐색 큐
        q = new LinkedList<>();
        // 초기바이러스 삽입
        for (int[] a : list) {
            q.offer(a);
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                if (map[x][y] != 0 || vis[x][y]) continue;
                safe--;
                q.offer(new int[]{x, y});
                vis[x][y] = true;
            }
        }

        return safe;
    }

    // 벽을 세울 위치 고르기
    static void bt(int n, int cnt) {
        // 벽을 다 세웠다면
        if (cnt == 3) {
            // 안전 구역 구해보고 최댓값 갱신
            max = max > bfs() ? max : bfs();
            return;
        }

        // 인덱스를 벗어 났다면
        if (n >= N * M) return;

        // n으로 좌표 구하기
        int x = n / M;
        int y = n % M;

        // 벽을 세울 수 있다면 세우기
        if (map[x][y] == 0) {
            // 벽 세우기
            map[x][y] = 1;
            bt(n + 1, cnt + 1);
            // 벽 치우기
            map[x][y] = 0;
        }

        // 안세우기
        bt(n + 1, cnt);
    }

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 빈칸 구하기
                if (map[i][j] == 0) empty++;
                    // 바이러스 위치 기억
                else if (map[i][j] == 2) list.add(new int[]{i, j});
            }
        }
        // 입력 끝

        // 안전 구역 탐색
        bt(0, 0);

        // 최대 안전 구역 출력
        System.out.println(max);
    }
}