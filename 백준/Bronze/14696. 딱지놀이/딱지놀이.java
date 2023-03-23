import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static void winner(int[] a, int[] b) {
        for (int j = 4; j > 0; j--) {
            if (a[j] > b[j]) {
                sb.append("A").append("\n");
                return;
            } else if (a[j] < b[j]) {
                sb.append("B").append("\n");
                return;
            }

        }
        sb.append("D").append("\n");
    }

    public static void main(String[] args) throws IOException {
        // 별 > 동그라미 > 네모 > 세모

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 개수 그림
        // 딱지에 나온 그림의 총개수 a / A가 낸 딱지의 그림
        // 1개 4
        // 4개 3 3 2 1
        for (int i = 0; i < N; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int aN = Integer.parseInt(st1.nextToken());
            int[] aD = new int[5];
            int bN = Integer.parseInt(st2.nextToken());
            int[] bD = new int[5];

            for (int j = 0; j < aN; j++) {
                aD[Integer.parseInt(st1.nextToken())]++;
            }
            for (int j = 0; j < bN; j++) {
                bD[Integer.parseInt(st2.nextToken())]++;
            }
            winner(aD, bD);
        }
        System.out.println(sb);
    }
}