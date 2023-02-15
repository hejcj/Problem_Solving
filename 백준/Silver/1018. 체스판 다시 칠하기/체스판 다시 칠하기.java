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

        boolean[][] board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'W') board[i][j] = true;
            }
        }

        int min = 60000;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                boolean[][] tempB = new boolean[8][8];
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        tempB[k - i][l - j] = board[k][l];
                    }
                }

                int cntA = 0;
                // 첫 줄 만들기
                for (int k = 1; k < 8; k++) {
                    if (tempB[0][k - 1] == tempB[0][k]) {
                        tempB[0][k] = !tempB[0][k];
                        cntA++;
                    }
                }

                for (int k = 1; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (tempB[k - 1][l] == tempB[k][l]) {
                            tempB[k][l] = !tempB[k][l];
                            cntA++;
                        }
                    }
                }

                tempB = new boolean[8][8];
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        tempB[k - i][l - j] = board[k][l];
                    }
                }
                tempB[0][0] = !tempB[0][0];

                int cntB = 1;
                // 첫 줄 만들기
                for (int k = 1; k < 8; k++) {
                    if (tempB[0][k - 1] == tempB[0][k]) {
                        tempB[0][k] = !tempB[0][k];
                        cntB++;
                    }
                }

                for (int k = 1; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (tempB[k - 1][l] == tempB[k][l]) {
                            tempB[k][l] = !tempB[k][l];
                            cntB++;
                        }
                    }
                }
                min = Math.min(Math.min(cntA, cntB), min);
            }
        }
        System.out.println(min);
    }
}
