import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean[][] adj;
    static boolean[] vis;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void recur(int ct, int who) {
        if (ct >= 2) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (adj[who][i]) {
                if(!vis[i]) {
                    vis[i] = true;
                    cnt++;
                }
                recur(ct + 1, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sta = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[sta][end] = true;
            adj[end][sta] = true;
        }
        vis = new boolean[N + 1];
        vis[1] = true;
        recur(0, 1);
        System.out.println(cnt);
    }
}