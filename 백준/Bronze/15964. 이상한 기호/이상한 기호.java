import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // A@B = (A+B) x (A-B)
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((a+b) * (a-b));
    }
}