import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // 정점 개수
    static int V;
    // 간선 개수
    static int E;
    // 간선 배열
    static int[][] edges;
    static int[] p;

    static void set(int x) {
        p[x] = x;
    }

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    static void unione(int x, int y) {
        p[y] = x;
    }

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        // 출력
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 1; tc < T + 1; tc++) {
            // 정점 수 입력
            V = sc.nextInt();
            // 간선 수 입력
            E = sc.nextInt();

            // 간선 정보 배열
            edges = new int[E][2];

            // 집합 계산 배열
            p = new int[V + 1];

            // 집합 생성
            for (int i = 1; i <= V; i++) {
                set(i);
            }

            // 간선 입력
            for (int i = 0; i < E; i++) {

                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                int x = find(edges[i][0]);
                int y = find(edges[i][1]);
                unione(x, y);
            }

            Set<Integer> groupNum = new HashSet<>();
            for(int i = 1; i <= V; i++) {
                groupNum.add(find(i));
            }

            sb.append("#").append(tc).append(" ").append(groupNum.size()).append("\n");
        }
        System.out.println(sb);
    }
}