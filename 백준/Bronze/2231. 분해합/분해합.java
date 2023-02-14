import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 가장 작은 생성자
        // x = n + 각자리수의 합

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int a = i;
            int b = 0;

            while (a > 0) {
                b += a % 10;
                a /= 10;
            }
            if (b + i == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
