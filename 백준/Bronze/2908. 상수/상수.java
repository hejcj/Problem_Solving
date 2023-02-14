import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        String a = st.nextToken();
        String b = st.nextToken();


        int aa = (a.charAt(0) - 48) + (a.charAt(1) - 48) * 10 + (a.charAt(2) - 48) * 100;
        int bb = (b.charAt(0) - 48) + (b.charAt(1) - 48) * 10 + (b.charAt(2) - 48) * 100;
        System.out.println(Math.max(aa,bb));
    }
}