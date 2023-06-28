import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static LinkedList<Integer>[] list;

    public static boolean bfs(int st, int ed) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(st);
        boolean[] vis = new boolean[N + 1];
        vis[st] = true;

        while (!q.isEmpty()) {

            if (vis[ed]) return true;
            int n = q.poll();
            for (int i : list[n]) {
                if (!vis[i]) {
                    q.offer(i);
                    vis[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if (bfs(start, end)) {
            System.out.println("yes");
            return;
        }
        if (bfs(end, start)) {
            System.out.println("no");
            return;
        }
        System.out.println("unknown");

    }
}