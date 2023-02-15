import java.util.Scanner;

/*
* 배열길이 고정
* 100 * 100
*
* 가로 세로 대각
*
* 2중 for 문
*
* 가로 세로 같이
*
* 대각선
*
* */
public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Testcase num
        int T = 10;
        

        // T번 반복        
        for (int i = 0; i < T; i++) {
        	// 최대값
        	int max = 0;
            int n = sc.nextInt();
            int[][] sum = new int[100][100];

            // 100x100 배열에 숫자 채우기
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    sum[j][k] = sc.nextInt();
                }
            }

            // 가로 세로
            for (int j = 0; j < 100; j++) {
                int row = 0;
                int col = 0;
                for (int k = 0; k < 100; k++) {
                    row += sum[j][k];
                    col += sum[k][j];
                }
                max = Math.max(Math.max(row, col), max);
            }

            // 대각선
            int a = 0;
            int b = 0;
            for (int j = 0; j < 100; j++) {
                a += sum[j][j];
                b += sum[j][100 - j - 1];
            }
            max = Math.max(Math.max(a, b), max);
            System.out.printf("#%d %d\n",i+1,max);
        }

    }
}
