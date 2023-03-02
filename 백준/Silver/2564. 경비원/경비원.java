import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        // 동 서 남 북 이 중요
        int T = Integer.parseInt(br.readLine());


        int[] direction = new int[T];
        int[] y = new int[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            direction[i] = Integer.parseInt(st3.nextToken());
            y[i] = Integer.parseInt(st3.nextToken());

        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st2.nextToken());
        int m = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < T; i++) {

            if (n == direction[i]) {
                if (m - y[i] > 0) {
                    result += m - y[i];
                } else result -=m - y[i];
            } else if (n == 1 ) {
                if (direction[i] == 3) {
                    result += y[i];
                    result += m;
                } else if (direction[i] == 4) {
                    result += N - m;
                    result += y[i];
                } else if (direction[i] == 2) {
                    result += M;
                    result += Math.min(m + y[i], N - m + N - y[i]);
                }
            } else if (n == 2) {

                if (direction[i] == 3) {
                    result += m;
                    result += M - y[i];
                } else if (direction[i] == 4) {
                    result += N - m;
                    result += M - y[i];
                } else if (direction[i] == 1) {
                    result += M;
                    result += Math.min((m + y[i]), (N - m) + (N - y[i]));
                }

            } else if (n == 3) {

                if (direction[i] == 1) {
                    result += m;
                    result += y[i];
                } else if (direction[i] == 2) {
                    result += M - m;
                    result += y[i];
                } else if (direction[i] == 4) {
                    result += N;
                    result += Math.min(m + y[i], M - m + M - y[i]);
                }

            } else if (n == 4) {
                if (direction[i] == 1) {
                    result += m;
                    result += N - y[i];
                } else if (direction[i] == 2) {
                    result += M - m;
                    result += N - y[i];
                } else if (direction[i] == 3) {
                    result += N;
                    result += Math.min(m + y[i], M - m + M - y[i]);
                }
            }
        }

        System.out.println(result);
        // 결과값 합
        // 동근이가 동서 / 남북

        // 동근이가 동서 일 때
            // 상점이 남북 일 때
            // 상점이 동서 일 때
        
        // 동근이가 남북 일 때
            // 상점이 동서 일 때
            // 상점이 남북 일 때
    }
}