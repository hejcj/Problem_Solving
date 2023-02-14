import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /// a*a = b*b + c*c
        Scanner sc = new Scanner(System.in);
        while (true) {
            int max = 0;
            int t = 0;
            int is_tri = 0;
            for (int i = 0; i < 3; i++) {
                t = sc.nextInt();
                if (t > max) {
                    is_tri += max * max;
                    max = t;
                } else {
                    is_tri += t * t;
                }
            }
            if (max == 0) {
                return;
            }
            if (is_tri == max * max) {
                System.out.println("right");
            } else System.out.println("wrong");
        }
    }
}
