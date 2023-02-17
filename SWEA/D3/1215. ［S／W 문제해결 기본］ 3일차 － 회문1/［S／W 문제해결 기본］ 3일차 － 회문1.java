import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
8x8회문
거꾸로읽어도 인도양 스위스 역삼역 우영우

가로 세로 직선만
 8x8이기때문에 완전탐색

8x8 배열을 순회하면서
해당길이만큼 문자열을 빼오고,

String.length/2 로
0~String.length -i
회문여부 탐색

회문인지 여부 탐색 후
회문이라면 ++

 */
public class Solution {
    public static void main(String[] args) throws IOException {

        int T = 10;
        int W = 8;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int cnt = 0;
            boolean is_Woo;

            // 입력받기
            int L = Integer.parseInt(br.readLine());

            // 배열
            char[][] chars = new char[W][W];

            for (int j = 0; j < W; j++) {
                String s = br.readLine();
                for (int k = 0; k < W; k++) {
                    chars[j][k] = s.charAt(k);
                    // 가로 탐색
                    if (k >= L-1) {
                        is_Woo = true;
                        // 문자열 판별 시작
                        for (int l = 0; l < L / 2; l++) {
                            if (chars[j][k - l] != chars[j][k - L + l + 1]) {
                                is_Woo = false;
                                break;
                            }
                        }
                        if(is_Woo) cnt++;
                    }

                    // 세로 탐색
                    if (j >= L -1) {

                        is_Woo = true;
                        // 문자열 판별 시작
                        for (int l = 0; l < L / 2; l++) {
                            if (chars[j - l][k] != chars[j - L + l + 1][k]) {
                                is_Woo = false;
                                break;
                            }
                        }
                        if (is_Woo) cnt++;
                    }
                }
            }
            sb.append("#").append(i + 1).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
