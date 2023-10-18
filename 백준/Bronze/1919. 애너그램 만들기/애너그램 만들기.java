import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)- 'a']++;
        }
        s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            arr2[s.charAt(i)- 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(arr[i] == arr2[i]) continue;
            if(arr[i] > arr2[i]) cnt += arr[i] - arr2[i];
            else  cnt += arr2[i] - arr[i];
        }
        System.out.println(cnt);
    }
}