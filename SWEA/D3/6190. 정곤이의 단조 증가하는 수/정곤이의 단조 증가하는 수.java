import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static int N;
    static int[] dan;
    static int danSU() {
        // 완전탐색 시작
        int max = -1;
        for (int j = 0; j < N - 1; j++) {
            for (int k = 1; k < N; k++) {
                // 중복선택 고려
                if (j != k) {
                    int target = dan[j] * dan[k];
                    // Ai x Aj % 10 스택에 쌓기
                    Stack<Integer> stack = new Stack<>();
                    // peek()값과 %10값 비교
                    while (target > 0) {
                        int num = target % 10;
                        // peek() 값이 작으면 탈출
                        if (!stack.isEmpty() && stack.peek() < num) {
                            // 타겟이 0이 되기 전에 break 되면 조건을 만족하지 않는 것
                            break;
                        }
                        stack.push(num);
                        target /= 10;
                    }
                    // 조건 만족 출력 종료
                    if (target == 0) {
                        max = max > dan[j] * dan[k] ? max : dan[j] * dan[k];
                    }
                }
            }
        }
        // 조건 불만족 -1 출력
        return max;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // 숫자 입력받기


        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();
            // 빈도수 정렬 내림 차순
            dan = new int[N];
            for (int j = 0; j < N; j++) {
                dan[j] =sc.nextInt();
            }
            System.out.println("#" + i + " " + danSU());
        }
    }
}