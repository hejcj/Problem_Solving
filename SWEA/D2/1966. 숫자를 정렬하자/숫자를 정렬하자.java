import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            // 빈도수 정렬하기 숫자의 범위를 주지 않음..
            // 일단 세자리수로 시작
            int[] arr = new int[1001];

            for (int i = 0; i < N; i++) {
                arr[sc.nextInt()]++;
            }

            // 출력
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    for (int j = 0; j < arr[i]; j++) {
                        sb.append(i).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}