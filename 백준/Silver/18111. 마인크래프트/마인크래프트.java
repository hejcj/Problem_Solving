import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 땅고르기 BFS
        // 1. 땅에 빈도수가 가장 높은 것
        // 인벤토리에 블록
        // 블록제거 2초 블록 꺼내서 놓기 1초
        // 어느 높이로 땅을 고를지 높은 땅부터 완전탐색
        // 해당 높이로 블록을 다 채울 인벤토리가 있는지 여부 
        // 총높이를 입력받을 때 계산
        // 원하는 높이로 다 채울 총높이 - 입력받을때 있던 높이 
        // 채울수 없으면 낮은 높이로 이동
        
        // 2차원 배열  크면 차이 *2 작으면 *1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st2.nextToken());
                sum += ground[i][j];
                max = Math.max(max, ground[i][j]);
            }
        }
        int cnt = 0;
        int h = 0;
        int min = Integer.MAX_VALUE;
        for (int i = max; i >= 0; i--) {
            if (N * M * i - sum <= B) {
                cnt = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        int n = ground[j][k];
                        if (n > i) {
                            cnt += (n - i) * 2;
                        } else if (n < i) {
                            cnt += (i - n);
                        }
                    }
                }
                if (min > cnt) {
                    h = i;
                    min = cnt;
                }
            }
        }

        System.out.println(min + " " + h);
    }
}
