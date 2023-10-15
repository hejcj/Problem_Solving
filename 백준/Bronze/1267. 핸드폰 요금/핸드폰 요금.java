import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            sumA += n / 30 * 10 + 10;
            sumB += n / 60 * 15 + 15;
        }
        if(sumA > sumB) {
            sb.append("M").append(" ").append(sumB);
        } else if (sumA < sumB) {
            sb.append("Y").append(" ").append(sumA);
        } else {
            sb.append("Y").append(" ").append("M").append(" ").append(sumB);
        }
        System.out.println(sb);
    }
}