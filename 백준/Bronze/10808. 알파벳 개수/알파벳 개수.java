import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] is= new int[26];

        for (int i = 0; i < s.length(); i++) {
            is[s.charAt(i)-97]++;
        }
        for (int i : is) {
            System.out.printf("%d ", i);
        }
    }
}