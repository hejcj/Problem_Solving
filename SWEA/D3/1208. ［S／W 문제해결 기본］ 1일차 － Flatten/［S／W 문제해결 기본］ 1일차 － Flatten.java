import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 10개의 테스트 케이스
        final int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append("#").append(i + 1).append(" ");
            int n = sc.nextInt();

            int[] count = new int[101];

            // 높이 가로길이 100이라서 101

            int sum = 0;
            // 원래 배열에 높이 빈도수 입력 받기
            for (int j = 0; j < 100; j++) {
                int height = sc.nextInt();
                count[height]++;
                sum += height;
            }
            int trigger = 1;
            if(sum % 100 == 0) trigger = 0;

            int front = 1;
            int back =100;
            while (n > 0) {
                while (count[front] == 0) {
                    front++;
                }
                while (count[back] == 0) {
                    back--;
                }

                if (back - front == trigger) {
                    break;
                }
                count[front+1]++;
                count[front]--;
                count[back]--;
                count[back-1]++;
                n--;

                while (count[front] == 0) {
                    front++;
                }
                while (count[back] == 0) {
                    back--;
                }
            }
            sb.append(back - front).append("\n");
        }
        System.out.println(sb);
    }
}
