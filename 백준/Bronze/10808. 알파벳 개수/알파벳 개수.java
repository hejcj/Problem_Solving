import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int n : arr) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}