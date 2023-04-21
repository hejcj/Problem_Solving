import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static int rx;
    static int ry;
    static int bx;
    static int by;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;

    static class Node {
        int x;
        int y;
        char type;

        public Node(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static void copyMap(char[][] target, char[][] choice) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                target[i][j] = choice[i][j];
            }
        }
    }

    static boolean gravity(int dir, int n) {
        Queue<Node> queue = new LinkedList<>();
        // 오른쪽
        if (dir == 0) {
            if (ry > by) {
                queue.offer(new Node(rx, ry, 'R'));
                queue.offer(new Node(bx, by, 'B'));
            } else {
                queue.offer(new Node(bx, by, 'B'));
                queue.offer(new Node(rx, ry, 'R'));
            }
        }
        // 아래쪽
        else if (dir == 1) {

            if (rx > bx) {
                queue.offer(new Node(rx, ry, 'R'));
                queue.offer(new Node(bx, by, 'B'));
            } else {
                queue.offer(new Node(bx, by, 'B'));
                queue.offer(new Node(rx, ry, 'R'));
            }
        }
        // 왼쪽
        else if (dir == 2) {
            if (ry < by) {
                queue.offer(new Node(rx, ry, 'R'));
                queue.offer(new Node(bx, by, 'B'));
            } else {
                queue.offer(new Node(bx, by, 'B'));
                queue.offer(new Node(rx, ry, 'R'));
            }
        }
        //위쪽
        else {
            if (rx < bx) {
                queue.offer(new Node(rx, ry, 'R'));
                queue.offer(new Node(bx, by, 'B'));
            } else {
                queue.offer(new Node(bx, by, 'B'));
                queue.offer(new Node(rx, ry, 'R'));
            }
        }
        boolean rGoal = false;
        // 큐에서 빼서 이동
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            while (map[x][y] != '#') {
                x += dx[dir];
                y += dy[dir];
                if (x < 0 || y < 0 || x >= N || y >= M) break;
                if (map[x][y] == '#' || map[x][y] == 'R' || map[x][y] == 'B') break;
                if (map[x][y] == 'O') {
                    map[x - dx[dir]][y - dy[dir]] = '.';
                    if (poll.type == 'R') rGoal = true;
                    else return true;
                    break;
                }
                map[x][y] = poll.type;
                if (poll.type == 'R') {
                    rx = x;
                    ry = y;
                } else {
                    bx = x;
                    by = y;
                }
                map[x - dx[dir]][y - dy[dir]] = '.';
            }
        }
        if (rGoal) {
            min = min < n ? min : n;
            return true;
        }
        return false;
    }


    static void dfs(int n, int dir) {

        if (min <= n) return;

        if (n == 11) {
            return;
        }

        char[][] temp = new char[N][M];
        copyMap(temp, map);


        int tempRx = rx;
        int tempRy = ry;
        int tempBx = bx;
        int tempBy = by;


        for (int i = 0; i < 4; i++) {
            if (dir == i) continue;
//            if ((dir+2) % 4 == i) continue;
            if (map[rx + dx[i]][ry + dy[i]] == '#' && map[bx + dx[i]][by + dy[i]] == '#') continue;
            // 중력작용
            if (!gravity(i, n)) dfs(n + 1, i);

            copyMap(map, temp);
            rx = tempRx;
            ry = tempRy;
            bx = tempBx;
            by = tempBy;
        }
    }


    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        // 입력 끝
        dfs(1, -1);


        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}