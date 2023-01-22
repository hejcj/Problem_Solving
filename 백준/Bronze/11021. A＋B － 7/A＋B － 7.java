import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt() + sc.nextInt();
            sb.append("Case #"+(i+1)+": "+a+"\n");
        }
        System.out.println(sb);
    }
}