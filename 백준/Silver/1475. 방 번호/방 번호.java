import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        // 2. 횟수 배열
        // 3. 10씩 나누어서 각 자리숫자 배열에 넣음
        // 4. 배열 순회 최대 숫자 출력
        // if 6이고 배열[9] < 배열[6] 배열 9 ++
        // if 9이고 배열[6] < 배열[9] 배열 6++
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = 0;
        int[] num = new int[10];
        while(n != 0){
            m = n % 10;
            if (m == 6 || m==9) {
                if(num[9] < num[6]) num[9]++;
                else num[6]++;
            } else{
                num[n % 10]++;
            }
            n /= 10;
        }
        int max = 0;
        for (int i : num) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
