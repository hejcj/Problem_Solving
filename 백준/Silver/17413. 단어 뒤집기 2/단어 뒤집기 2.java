import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 출력
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String s = br.readLine();

        // 문장 인덱스
        int idx = 0;

        boolean isWord = false;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {

                for (int j = i - 1; j >= start; j--) {
                    sb.append(s.charAt(j));
                }
                isWord = true;
            } else if (c == '>') {
                sb.append(c);
                start = i + 1;
                isWord = false;
            } else if (!isWord && c == ' ') {
                for (int j = i - 1; j >= start; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(c);
                isWord = false;
                start = i + 1;
            }
            if(isWord) sb.append(c);
        }

        if (s.charAt(s.length() - 1) != ' ' && s.charAt(s.length() - 1) != '>') {
            for (int i = s.length()-1; i >= start; i--) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);

    }
}