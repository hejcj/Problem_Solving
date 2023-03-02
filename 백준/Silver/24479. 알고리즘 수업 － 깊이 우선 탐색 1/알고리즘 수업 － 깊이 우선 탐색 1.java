import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] V;
    static int[] E;
    static int[] visited;
    static int cnt = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();



    static void dfs(int R) {
        cnt++;
        visited[R] = cnt;

        for (int i : graph.get(R)) {
            if (visited[i] == 0) dfs(i);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        V = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> integers : graph) {
            Collections.sort(integers);
        }

        dfs(R);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}