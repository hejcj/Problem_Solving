import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a > 96) {
                count[a - 97]++;
            } else {
                count[a - 65]++;
            }
        }
        int max = 0;
        int is_count = 0;
        int index = 0;
        for (int i =0; i < count.length; i++) {

            if (max < count[i]) {
                is_count = 0;
                max = count[i];
                index = i;
            } else if (max == count[i]) is_count++;
        }

        if(is_count > 0) System.out.println("?");
        else System.out.println((char)(index+65));
    }
}
