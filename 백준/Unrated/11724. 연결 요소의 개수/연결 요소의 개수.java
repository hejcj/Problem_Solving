import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 정점의 개수
    static int N;

    // 간선의 개수
    static int M;

    // 방문처리 배열
    static boolean[] vis;

    // 인접리스트
    static List<Integer>[] adjList;

    static void dfs(int n) {
        for (int a : adjList[n]) {
            if (vis[a]) continue;
            vis[a] = true;
            dfs(a);
        }
    }

    //DFS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vis = new boolean[N+1];
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);

        }
        for (int j = 1; j  < N +1 ; j++) {
            if(vis[j]) continue;
            cnt++;
            vis[j] = true;
            dfs(j);
        }
        System.out.println(cnt);


    }
}