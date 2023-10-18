import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] arr = new char[26];
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isFlag = false;
            String s = st.nextToken();
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            s = st.nextToken();
            for (char c : s.toCharArray()) {
                arr[c - 'a']--;
            }
            for (int j = 0; j < 26; j++) {
                if(arr[j] > 0) {
                    isFlag = true;
                    break;
                }
            }
            if(isFlag) result.append("Impossible").append("\n");
            else result.append("Possible").append("\n");
        }
        System.out.println(result);
    }
}