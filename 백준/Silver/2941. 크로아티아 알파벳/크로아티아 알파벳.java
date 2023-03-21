import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            cnt++;
            if (i + 1 >= s.length()) continue;
            char c2 = s.charAt(i + 1);
            switch (c) {
                case 'c':
                    if (c2 == '=' || c2 == '-' ) i++;
                    break;
                case 'd':
                    if(c2 == '-') i++;
                    else {
                        if(i+2 >= s.length()) continue;
                        if(s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') i +=2;
                    }
                    break;
                case 'l':
                case 'n':
                    if(c2 == 'j') i++;
                    break;
                case 's':
                case 'z':
                    if(c2 == '=') i++;
                    break;
                default:
                    break;
            }

        }
        System.out.println(cnt);
    }
}