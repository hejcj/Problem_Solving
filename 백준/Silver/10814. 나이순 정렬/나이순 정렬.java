import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] person = new StringBuilder[201];

        for (int i = 0; i < person.length; i++) {
            person[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            person[Integer.parseInt(s[0])].append(s[0]).append(" ").append(s[1]).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 200; i++) {
            sb.append(person[i]);
        }
        System.out.println(sb);
    }
}
