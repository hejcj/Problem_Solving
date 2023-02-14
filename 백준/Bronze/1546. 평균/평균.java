import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            max = Math.max(a, max);
            sum += a;
        }
        System.out.println(100/max * sum / n);
    }
}