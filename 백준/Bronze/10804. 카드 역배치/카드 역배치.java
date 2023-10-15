import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr = new int[21];

    public static void swap(int start, int end) {

        for (int i = start; i <= ( end + start ) / 2; i++) {
            int n = arr[i];
            arr[i] = arr[end + start - i];
            arr[end + start - i] = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < 21; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}