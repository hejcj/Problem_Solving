import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 주사위 이차원 배열
        // 0 == 5
        // 1 == 3
        // 2 == 4
        // 주사위 상하를 이루는 숫자를 제외하고 가장 큰값을 더해준다.
        // 1번 주사위를 어떻게 놓느냐에 따라
        // 6가지 경우의 수가 생긴다

        // 가장 큰 값을 구해본다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dice = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 맥스값
        int max = 0;

        // 1번 다이스를 어떻게 놓느냐에 따라 6가지 경우의 수
        for (int i = 1; i <= 6; i++) {
            // 1번 다이스를 i을 위로 향하게 했을 때

            // 주사위가 맞닿는 부분 숫자
            int contact = i;

            // 임시 값
            int sum = 0;


            // 1번 다이스를 A를 위로 향하게 했을 때
            // 0,5번 인덱스를 제외하고 가장 큰 수 더해줌
            // 2번 다이스에서 A와 같은 숫자의 인덱스를 찾아 주고
            // 인덱스와 맞는 값을 찾아서 반복해주기

            // N번 주사위 반복
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] == contact) {
                        // A F
                        if (k == 0 || k == 5) {
                            if (k == 0) contact = dice[j][5];
                            if (k == 5) contact = dice[j][0];
                            int tempmax = 0;
                            for (int l = 0; l < 6; l++) {
                                if(l == 0 || l == 5) continue;
                                tempmax = Math.max(dice[j][l], tempmax);
                            }
                            sum += tempmax;
                        }
                        // B D
                        else if (k == 1 || k == 3) {
                            if (k == 1) contact = dice[j][3];
                            if (k == 3) contact = dice[j][1];

                            int tempmax = 0;
                            for (int l = 0; l < 6; l++) {
                                if(l == 1 || l == 3) continue;
                                tempmax = Math.max(dice[j][l], tempmax);
                            }
                            sum += tempmax;
                        }
                        // C E
                        else {
                            if (k == 2) contact = dice[j][4];
                            if (k == 4) contact = dice[j][2];

                            int tempmax = 0;
                            for (int l = 0; l < 6; l++) {
                                if(l == 2 || l == 4) continue;
                                tempmax = Math.max(dice[j][l], tempmax);
                            }
                            sum += tempmax;
                        }
                        break;
                    }
                }
            }

            max = Math.max(sum, max);


        }
        System.out.println(max);
    }
}