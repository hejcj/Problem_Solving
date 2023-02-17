import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        /*
        다받고, 오른쪽 아래쪽 회문일 때 까지 탐색
        max 비교
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 10
        int T = 10;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            // 테스트 번호 입력
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(n).append(" ");
            // 회문 배열 입력
            // 100 x 100
            char[][] woo = new char[100][100];
            int max = 0;

            // 배열 입력받으면서 왼쪽이랑 위쪽 탐색 가능!
            for (int j = 0; j < 100; j++) {
                String s = br.readLine();
                for (int k = 0; k < 100; k++) {

                    woo[j][k] = s.charAt(k);

                    // 왼쪽 인덱스 까지
                    // 위쪽 인덱스 까지
                    // 제일 긴 넓이 부터
                    // 제일 짧은 넓이까지 탐색 중간에 회문 이있다면 max값 활성화 후 탈출
                    // 없다면 1까지
                    // 배열의 인덱스 끝까지 탐색
                    // 가장 길이가 긴 회문 숫자 출력

                    // 가로 탐색
                    for (int l = k + 1; l >= 2; l--) {

                        boolean is_Woo = true;

                        for (int z = 0; z < l / 2; z++) {
                            if (woo[j][k - l +1  + z] != woo[j][k - z]) {

                                is_Woo = false;
                                break;
                            }
                        }
                        if (is_Woo) if (max < l) max = l;
                    }


                    // 세로 탐색
                    for (int l = j + 1; l >= 2; l--) {
                        boolean is_Woo = true;

                        for (int z = 0; z < l / 2; z++) {
                            if (woo[j - l + 1 + z][k] != woo[j - z][k]) {

                                is_Woo = false;
                                break;
                            }
                        }
                        if (is_Woo) if (max < l) max = l;
                    }
                }
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);


    }
}
