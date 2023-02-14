import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] result = new int[42];
        int score = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            result[Integer.parseInt(br.readLine()) % 42]++;
        }
        for (int i = 0; i < 42; i++) {
            if(result[i] > 0) score++;
        }
        System.out.println(score);
    }
}
