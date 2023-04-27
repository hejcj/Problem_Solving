import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    static int[] cA;
    static int[] cB;

    static int min = Integer.MAX_VALUE;

    static void score(int n, int a, int b, int diff) {

       if(a == N/2 && b == N/2) {

           if(diff < 0) diff = -diff;
           min = min < diff ? min : diff;
           return;
       }

       int temp = diff;
       if( n >= N) return;
        if(a < N/2) {
            cA[a] = n;
            for (int i = 0; i < a; i++) {
                temp += map[cA[i]][n];
                temp += map[n][cA[i]];
            }
            score(n + 1 ,  a + 1, b , temp);
        }

        if(b < N/2) {
            temp = diff;
            cB[b] = n;
            for (int i = 0; i < b; i++) {
                temp -= map[cB[i]][n];
                temp -= map[n][cB[i]];
            }
            score(n + 1 ,  a, b + 1, temp);
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cA = new int[N / 2];
        cB = new int[N / 2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        score(0, 0, 0, 0 );

        System.out.println(min);

    }

}