import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = Integer.parseInt(br.readLine());
        int idx = 1;
        for (int i = 2; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n > max) {
                max = n;
                idx = i;
            }
        }
        sb.append(max).append("\n").append(idx);
        System.out.println(sb);
    }
}