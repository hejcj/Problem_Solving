import java.util.Scanner;

public class Solution {
    static int pow(int N, int M) {
        if(M == 1) return N;

        int r = pow(N, M / 2);
        if (M % 2 == 0) {
            return r * r;
        }

        return r * r * N;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append("#").append(sc.next()).append(" ");

            int N = sc.nextInt();
            int M = sc.nextInt();

            sb.append(pow(N, M)).append("\n");
        }
        System.out.println(sb);
    }
}
