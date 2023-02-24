import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능!!!!!!
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= T; i++) {

            int N = Integer.parseInt(sc.nextLine());
            // String을 받아서 , charAt - '0'
            int[][] farm = new int[N][N];

            int m = N / 2;
            // n이 1일때 max 값 찾기
            int max = 0;
            for (int j = 0; j < N; j++) {
                String s = sc.nextLine();
                for (int k = 0; k < N; k++) {
                    // 농작물의 가치는 0~5 이기 떄문에 가능
                    farm[j][k] = s.charAt(k) - '0';
                    if(j == m) max += farm[j][k];
                }
            }

            // n/2 y에서 시작해서 양쪽 끝으로 가면서 모두 더해주기
            for (int j = 1; j <= m; j++) {
                for (int k = j; k < N - j; k++) {
                    // 위쪽으로
                    max += farm[m - j][k];
                    // 아래쪽으로
                    max += farm[m + j][k];

                }
            }
            System.out.println("#" + i + " " + max);
        }
    }
}