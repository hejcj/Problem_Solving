import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 1) {
            System.out.println("1");
            return;
        }

        int six = 6;
        int count = 2;
        int front = 2;
        int back = 7;
        while (true) {

            if (front <= n && n <= back) {
                System.out.println(count);
                return;
            }
            front += six;
            six += 6;
            back += six;
            count++;
        }
    }
}
