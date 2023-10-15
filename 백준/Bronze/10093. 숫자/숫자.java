import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if(A == B) {
            System.out.println(0);
            return;
        }
        long min = A;
        long max = B;
        if(A > B) {
            min = B;
            max = A;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max - min - 1).append("\n");
        for (long i = min + 1; i < max; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}