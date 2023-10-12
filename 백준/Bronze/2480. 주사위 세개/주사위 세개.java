import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[7];
        int result = 0;
        for (int i = 0; i < 3; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        for (int i = 6; i > 0; i--) {
            if(arr[i] == 3) {
                result = 10000 + (i * 1000);
                break;
            } else if (arr[i] == 2) {
                result = 1000 + (i * 100);
                break;
            } else if (arr[i] == 1 && result == 0) {
                result = i * 100;
            }
        }
        System.out.println(result);
    }
}