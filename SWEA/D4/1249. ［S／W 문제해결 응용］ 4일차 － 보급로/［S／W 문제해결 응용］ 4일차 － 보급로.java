import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    // 프라이어티 큐 코스트가 가장 낮은 것 부터 탐색
    // 도착지에 먼저 도착하면 탐색 중단할 수 있게 되기 때문에
    // 우선순위 큐 사용 다익스트라는 BFS
    // Node에 필요한 정보는 x,y,cost

    // 지도 크기
    static int N;
    // 지도
    static int[][] map;

    // 방문 배열 및, 코스트 계산
    static int[][] dist;

    // 다익스트라 탐색을 위한 PQ
    static PriorityQueue<Node> pq;

    // 델타배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    // 노드
    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static void bfs() {
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (poll.x == N - 1 && poll.y == N - 1) break;
            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N) continue;
                if (dist[x][y] <= poll.cost + map[x][y]) continue;
                pq.offer(new Node(x, y, poll.cost + map[x][y]));
                dist[x][y] = poll.cost + map[x][y];
            }

        }
    }

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        // 출력
        StringBuilder sb = new StringBuilder();

        // TC
        int T = sc.nextInt();
        for (int tc = 1; tc < T + 1; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            dist = new int[N][N];
            pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });

            for (int i = 0; i < N; i++) {
                String next = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = next.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dist[0][0] = 0;
            pq.offer(new Node(0, 0, 0));
            bfs();
            sb.append("#").append(tc).append(" ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }
}