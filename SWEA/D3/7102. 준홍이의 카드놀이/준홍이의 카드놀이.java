import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.printf("#%d ", i);
            int[] arr = new int[N + M + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    arr[j + k]++;
                }
            }

            int max = 0;
            for (int j = 2; j < N + M + 1; j++) {
                max = max > arr[j] ? max : arr[j];
            }

            for (int j = 2; j < N + M + 1; j++) {
                if (arr[j] == max) {
                    System.out.printf("%d ", j);
                }
            }
            System.out.println();

        }
    }
}