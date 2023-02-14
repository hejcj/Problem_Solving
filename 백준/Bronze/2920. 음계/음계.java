import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean is_asc = true;
        boolean is_des = true;
        for (int i = 1; i <= 8; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(i != n) is_asc = false;
            if(9-i != n) is_des = false;

        }
        if(is_asc) System.out.println("ascending");
        else if(is_des) System.out.println("descending");
        else System.out.println("mixed");
    }
}