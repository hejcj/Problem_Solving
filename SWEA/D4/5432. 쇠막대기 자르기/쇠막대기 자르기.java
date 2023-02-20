import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    레이저가 완성될 때 스택에 쌓여있는 괄호 수만큼 늘어난다.
    괄호가 열릴 때 스택에 추가
    괄호가 닫힐 때 레이저가 아니라면 쇠막대기 하나 추가하고 스택에서 삭제
    괄호가 닫힐 때 레이저라면 스택 사이즈만큼 쇠막대기 추가
    스트링의 인덱스로
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                // 괄호가 열릴 때
                if (s.charAt(j) == '(') {
                    // 스택에 추가
                    stack.push(s.charAt(j));
                } else {
                    // 레이저라면
                    if (s.charAt(j - 1) == '(') {
                        
                        // 레이저 괄호 제거
                        stack.pop();
                        // 남아있는 쇠막대기 자르기
                        sum += stack.size();
                    }
                    // 레이저가 아니라면
                    else {
                        stack.pop();
                        sum++;
                    } 
                }
            }
            System.out.printf("#%d %d\n", i + 1, sum);
        }
    }
}
