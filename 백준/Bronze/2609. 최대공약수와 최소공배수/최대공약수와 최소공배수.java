import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* 두개의 자연수 최대 공약수와 최소 공배수*/

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = Math.min(a, b); i >= 1 ; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }
        int indexA = 1;
        int indexB = 1;
        // 소인수 분해 후
        //
        while (a*indexA != b*indexB) {
            if(a*indexA > b*indexB) indexB++;
            else indexA++;
        }
        System.out.println(a*indexA);
    }
}
