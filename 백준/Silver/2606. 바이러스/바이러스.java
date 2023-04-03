import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 간선 배열 저장
    // 인접 행렬
    static boolean[][] graph;

    //  컴퓨터의 수
    static int N;
    // 간선의 수
    static int M;

    // 바이러스 전파되는 숫자
    static int count = 0;
    // 방문배열
    static boolean[] dist;

    // DFS로 탐색
    static void recur(int st) {

        for (int i = 1; i < N + 1; i++) {
            if (graph[st][i] && !dist[i]) {
                dist[i] = true;
                count++;
                recur(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 컴퓨터는 1부터 시작
        graph = new boolean[N + 1][N + 1];
        dist = new boolean[N + 1];

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 무향 그래프이기 때문에
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        // 1번 부터 시작
        dist[1] = true;
        recur(1);
        System.out.println(count);
    }
}