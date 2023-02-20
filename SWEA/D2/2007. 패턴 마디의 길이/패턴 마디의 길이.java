import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*
        문자열을 1로 잘라보기
        2로 잘라보기
        3으로 잘라보기
        ...
        만약 잘랐을때 마디가 총 길이를 자를수있는 마디로 나누기
        
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();

            
            sb.append("#").append(i + 1).append(" ");

            boolean is_madi = false;
            // 마디의 최대길이 10
            for (int j = 1; j <= 10; j++) {

                // 첫마디
                String s1 = s.substring(0, j);
                // 두마디
                String s2 = s.substring(j, j + j);

                // 첫마디&& 두마디 비교
                // 마디가 형성된다면
                if (s1.equals(s2)) {

                    // 마디 길이 출력
                    sb.append(j).append("\n");
                    is_madi = true;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}