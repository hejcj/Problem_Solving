import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 비밀 이메일
        // R <= C. R*C = N R과 C 를 고른다
        // 만약, 그러한 경우가 여러 개일 경우, R이 큰 값을 선택한다.


        // 그다음 행이 R개고 열이 C개인 행렬을 만든다.

        // 길이를 통해서 R *C 행령을 고른다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int R = 1;
        int C = 0;
        for (int i = 2; i <= Math.sqrt(s.length()); i++) {
            if (s.length() % i == 0) R = i;
        }

        R = Math.min(R, s.length() / R);
        StringBuilder sb = new StringBuilder();


        //
        for (int i = 0; i < R; i++) {

            for (int j = 0; j < s.length(); j +=R) {
                sb.append(s.charAt(i + j));
            }
        }
        System.out.println(sb);
    }
}