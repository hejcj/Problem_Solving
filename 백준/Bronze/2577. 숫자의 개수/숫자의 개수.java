import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int target = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        while (target > 0) {
            arr[target % 10]++;
            target /= 10;
        }
        for (int n : arr) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }
}