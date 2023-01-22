import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length()/10; i++) {
            sb.append(s.substring(10*i, 10*i +10));
            sb.append("\n");
        }
        sb.append(s.substring( (s.length()/10)*10 , s.length()));
        System.out.println(sb);
    }
}