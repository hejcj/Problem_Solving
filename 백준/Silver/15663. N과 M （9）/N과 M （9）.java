import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] choice;
    static boolean[] dist;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();


    static void recur(int n) {
        if (n == M) {
            String s = "";
            for (int i = 0; i < M; i++) {
                s += choice[i];
                s += " ";
            }
            if(set.contains(s)) return;
            set.add(s);
            sb.append(s).append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (dist[i]) continue;
            choice[n] = arr[i];
            dist[i] = true;
            recur(n + 1);
            dist[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        choice = new int[M];
        dist = new boolean[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        recur(0);

        System.out.println(sb);
    }
}