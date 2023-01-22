import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = n; i > 0; i--) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}