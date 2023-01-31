
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[] arr1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i)-97]++;

        }
        for (int i = 0; i < s2.length(); i++) {
            arr1[s2.charAt(i)-97]--;
        }
        int sum =0;
        for (int i = 0; i < 26; i++) {
            if(arr1[i] < 0) sum -= arr1[i];
            else sum += arr1[i];
        }
        System.out.println(sum);
    }
}