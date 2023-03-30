import java.util.Scanner;

public class Solution {

    // 섬의 숫자
    static int N;
    // 세율
    static double E;
    // 인접행렬
    static double[][] adjArr;
    // 섬의 위치 정보 배열
    static int[][] dot;
    // 섬 연결 코스트 배열
    static double[] dist;
    static boolean[] vis;

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            dot = new int[N][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < N; j++) {
                    dot[j][i] = sc.nextInt();
                }
            }
            E = sc.nextDouble();
            adjArr = new double[N][N];

            // 좌표 정보로 코스트 계산하여 인접행렬로 만들기
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    double a = dot[i][0] - dot[j][0];
                    double b = dot[i][1] - dot[j][1];
                    adjArr[i][j] = E * (a * a + b * b);
                    adjArr[j][i] = E * (a * a + b * b);

                }
            }

            dist = new double[N];
            for (int i = 0; i < N; i++) {
                dist[i] = Double.MAX_VALUE;
            }
            vis = new boolean[N];
            dist[0] = 0;

            // 인접행렬을 통하여 계산하기
            for (int i = 0; i < N - 1; i++) {
                int target = -1;
                double min = Double.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if(vis[j]) continue;
                    if (min > dist[j]) {
                        min = dist[j];
                        target = j;
                    }
                }
                vis[target] = true;
                for (int j = 0; j < N; j++) {
                    if(vis[j]) continue;
                    if (dist[j] > adjArr[target][j]) {
                        dist[j] = adjArr[target][j];
                    }
                }
            }
            double result = 0;
            for (int i = 0; i < N; i++) {
                result += dist[i];
            }
            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
        }
        System.out.println(sb);
    }
}