import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


    // 2차원 배열 보드의 크기
    static int N;
    // 사과의 개수
    static int K;
    // 방향 변환 횟수
    static int L;
    // 사과 위치 입력
    static boolean[][] map;
    // 뱀이 위치 방문배열
    static boolean[][] vis;
    // 방향전환 정보
    static int dIdx = 0;
    static int[] dTime;
    static char[] dDirection;
    // 뱀 위치 저장 머리 꼬리 사용
    static Deque<Node> deque = new LinkedList<>();
    // 방향 탐색 델타 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    // 뱀의 머리 위치
    static int x = 1;
    static int y = 1;
    // 뱀의 방향
    static int d = 0;
    // 걸린 시간
    static int time = 0;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        // 1,1이 시작위치
        map = new boolean[N + 1][N + 1];
        vis = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        L = Integer.parseInt(br.readLine());
        dTime = new int[L];
        dDirection = new char[L];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dTime[i] = Integer.parseInt(st.nextToken());
            dDirection[i] = st.nextToken().charAt(0);
        }
        // 입력 끝

        // 뱀 이동 시작
        vis[1][1] = true;
        deque.offerFirst(new Node(1, 1));

        while (true) {
            time++;

            x += dx[d];
            y += dy[d];
            if (x < 1 || y < 1 || x > N || y > N || vis[x][y]) {
                System.out.println(time);
                return;
            }
            deque.offerFirst(new Node(x, y));
            vis[x][y] = true;
            if (!map[x][y]) {
                Node node = deque.pollLast();
                vis[node.x][node.y] = false;
            } else map[x][y] = false;

            if (dIdx < L && dTime[dIdx] == time) {
                if (dDirection[dIdx] == 'L') d = (d + 3) % 4;
                else d = (d + 1) % 4;
                dIdx++;
            }
        }
    }
}