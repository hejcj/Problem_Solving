import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i)<91) sb.append((char) (s.charAt(i) +32));
            else sb.append((char)(s.charAt(i) -32));
        }
        System.out.println(sb);
    }
}