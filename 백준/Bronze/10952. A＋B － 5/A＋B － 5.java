import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        boolean flag = true;

        while(flag){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if(a == 0) {
                System.out.println(sb);
                flag =false;
                break;
            } else {
                sb.append(a).append("\n");
            }
        }
    }
}
