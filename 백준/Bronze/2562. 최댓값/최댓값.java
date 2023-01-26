import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            int a = Integer.parseInt(br.readLine());
            if ( a > max) {
                max = a;
                cnt = i;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}