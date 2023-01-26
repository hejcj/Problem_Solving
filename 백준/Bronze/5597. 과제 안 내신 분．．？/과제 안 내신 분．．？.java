import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];
        for (int i = 0; i < 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i <= 30; i++) {
            if(arr[i] == false) System.out.println(i);
        }
    }
}