import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 미로에서 일을한다 홍홍
        // 불에 타기전에 탈출할 수 있는지에 여부
        // 얼마나 빨리 탈출?
        // 지훈이와 불은 한칸씩 가로세로 이동
        // 불은 가로세로 확산
        // 미로의 가장자리에 접한 공간에서 탈출
        // 지훈이와 붙은 벽이 있는 공간 통과 X

        // 탈출 조건 지훈이가 x좌표 0 or x = N-1 or y =0 or y =N-1
        // 중간에 불이 만나면 IMPOSSIble
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        boolean[][] vis = new boolean[N][M];

        int jdx = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == '#') {
                    maze[i][j] = -1;
                } else if (c == 'F') {
                    maze[i][j] = 1;
                    queue.offer(new int[]{i, j, 1});
                } else if (c == 'J') {
                    maze[i][j] = 2;
                    queue.offer(new int[]{i, j, 2 , 1});
                    vis[i][j] = true;
                }
            }
        }

        while (queue.peek()[2] != 2) {
            queue.offer(queue.poll());
        }
        while (jdx > 0) {

            int[] poll = queue.poll();

            if (maze[poll[0]][poll[1]] == 2 && poll[2] == 2) {
                jdx--;
                maze[poll[0]][poll[1]] = 0;
                for (int i = 0; i < 4; i++) {
                        int x = poll[0] + dx[i];
                        int y = poll[1] + dy[i];

                    if (x < 0 || x >= N || y < 0 || y >= M) {
                        System.out.println(poll[3]);
                        return;
                    } else if (maze[x][y] == 1 || maze[x][y] == -1 || maze[x][y] == 2 || vis[x][y]) {
                        continue;
                    }
                    maze[x][y] = 2;
                    jdx++;
                    vis[x][y] = true;
                    queue.offer(new int[]{x, y, 2, poll[3] + 1});
                }
            } else if (poll[2] == 1) {
                for (int i = 0; i < 4; i++) {
                    int x = poll[0] + dx[i];
                    int y = poll[1] + dy[i];

                    if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                    }
                    if (maze[x][y] == -1 || maze[x][y] == 1) continue;
                    if (maze[x][y] == 2) {
                        jdx--;
                    }
                    maze[x][y] = 1;
                    queue.offer(new int[]{x, y, 1});
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}