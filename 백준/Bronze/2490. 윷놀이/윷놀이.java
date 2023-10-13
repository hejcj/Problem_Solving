import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 3; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = 0;
            char c = 'E';
            for (int i = 0; i < 4; i++) {
                n += Integer.parseInt(st.nextToken());
            }
            if (n == 0 ) {
                c = 'D';
            } else if (n == 1) {
                c = 'C';
            } else if (n == 2) {
                c = 'B';
            } else if (n == 3) {
                c = 'A';
            }
            sb.append(c).append("\n");
        }
        System.out.println(sb);
    }
}