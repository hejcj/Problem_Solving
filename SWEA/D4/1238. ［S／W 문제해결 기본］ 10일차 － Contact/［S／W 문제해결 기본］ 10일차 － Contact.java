import java.util.*;


public class Solution {

    // 크기
    static int N;

    // 시작점
    static int start;
    // 인접리스트
    static List<Integer>[] adjList;
    // BFS
    // 방문 배열
    static boolean[] vis;

    static Deque<Node> q;
    static int max;
    static int maxN;

    static class Node {
        int st;
        int ed;
        int cnt;

        public Node(int st,int ed, int cnt) {
            this.st = st;
            this.ed = ed;
            this.cnt = cnt;
        }
    }

    // 간선이 아닌 정점으로 풀이 프림 알고리즘을 사용할 수 있을까?
    // 프림 알고리즘으로 풀어보기, 프라이어티 & 반복문
    // 인접리스트 인접행렬

    public static void main(String[] args) {
        // 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수

        // 프림 알고리즘 priority Queue 은 아닌 것같네
        // 입력
        Scanner sc = new Scanner(System.in);
        // 출력
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for (int tc = 1; tc < T + 1; tc++) {
            N = sc.nextInt();
            start = sc.nextInt();

            vis = new boolean[101];
            adjList = new ArrayList[100 + 1];
            for (int i = 1; i < 101; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < N/2; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();
                adjList[st].add(ed);
            }

            // 탐색 때 우선순위 큐가 필요 하다!
            // 덱으로 풀이
            q = new LinkedList<>();
            // 방문 처리
            vis[start] = true;
            max = 1;
            maxN = start;
            // 시작점 부터 집어 넣기
            for (int n : adjList[start]) {
                q.offer(new Node(start,n, 2));
            }

            // 마지막 번호
            //
            // 큐로 탐색
            while (!q.isEmpty()) {
                Node poll = q.poll();
                if (poll.cnt > max) {
                    max = poll.cnt;
                    maxN = poll.ed;
                } else if (poll.cnt == max && maxN < poll.ed)
                    maxN = poll.ed;

                for (int n : adjList[poll.ed]) {
                    if(vis[n]) continue;
                    vis[n] = true;
                    q.offer(new Node(poll.ed, n, poll.cnt + 1));
                }
            }
            sb.append("#").append(tc).append(" ").append(maxN).append("\n");
        }
        System.out.println(sb);
    }
}