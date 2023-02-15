import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (!(s = br.readLine()).equals("0")) {
            boolean is_yes = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    sb.append("no").append("\n");
                    is_yes = false;
                    break;
                }
            }
            if(is_yes) sb.append("yes").append("\n");
        }

        System.out.println(sb);
    }
}
